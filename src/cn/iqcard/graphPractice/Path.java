package cn.iqcard.graphPractice;

import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;

public class Path {
    private boolean[] visited;
    private int[] from;
    private int s;//起点
    private Graph G;

    private void dfs(int v){
        if(!visited[v]){
            visited[v]=true;
            Vector<Integer> adjV=G.adj(v);
            Iterator<Integer> it=adjV.iterator();
            while (it.hasNext()){
                int i=it.next();
                from[i]=v;
                dfs(i);
            }
        }
    }

    public Path(Graph g,int s){
        this.visited=new boolean[g.V()];
        this.from=new int[g.V()];
        this.s=s;
        this.G=g;

        for (var i=0;i<g.V();i++){
            from[i]=-1;
        }

        dfs(s);
    }

    public boolean hasPath(int w){
        return visited[w];
    }

    public Vector<Integer> getPath(int w){
        Stack<Integer> st=new Stack<Integer>();
        while(w>=0){
            st.push(w);
            w=from[w];
        }
        Vector<Integer> vt=new Vector<Integer>();

        while (!st.isEmpty()){
            vt.add(st.pop());
        }

        return vt;
    }

    public void showPath(int w){
        System.out.println("打印路径 ");
        System.out.println("打印from");
        for(int i=0;i<from.length;i++){
            System.out.print(from[i]);
        }
        Vector<Integer> vt=getPath(w);
        for (int i : vt){
            System.out.print(i+"\t");
        }
    }

}
