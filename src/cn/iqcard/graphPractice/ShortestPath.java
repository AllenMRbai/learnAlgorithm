package cn.iqcard.graphPractice;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Vector;

public class ShortestPath {
    private Graph G;
    private int s;
    private boolean[] visited;
    private int[] from; // 记录路径, from[i]表示查找的路径上i的上一个节点
    private int[] ord; // 记录路径中节点的次序。ord[i]表示i节点在路径中的次序。

    public ShortestPath(Graph g,int s){
        this.G=g;
        assert s>=0&&s<g.V();
        this.s=s;

        visited=new boolean[g.V()];
        from=new int[g.V()];
        ord=new int[g.V()];
        for (var i=0;i<g.V();i++){
            from[i]=-1;
            ord[i]=-1;
        }

        LinkedList<Integer> ll=new LinkedList<Integer>();

        ll.add(s);
        System.out.println("打印 shortest的form的pop");
        visited[s]=true;
        ord[s]=0;
        while (!ll.isEmpty()){
            int c=ll.poll();
            System.out.print(c);
            for (int i:G.adj(c)){
                if(!visited[i]){
                    ll.add(i);
                    visited[i]=true;
                    from[i]=c;
                    ord[i]=ord[c]+1;
                }
            }
        }

    }

    public boolean hasPath(int v){
        return visited[v];
    }

    public Vector<Integer> getPath(int v){
        assert hasPath(v);

        Stack<Integer> st=new Stack<Integer>();
        int p=v;
        while (p>=0){
            st.push(p);
            p=from[p];
        }

        Vector<Integer> vc=new Vector<>();

        while (!st.isEmpty()){
            vc.add(st.pop());
        }

        return vc;
    }

    public void showPath(int v){
        assert hasPath(v);
        Vector<Integer> vc=getPath(v);
        System.out.println("打印ord");
        MyUtils.printArr(ord);
        System.out.println();
        System.out.println("最短路径为");
        System.out.println(vc);
        System.out.println("打印最短路径的from");
        MyUtils.printArr(from);
    }
}
