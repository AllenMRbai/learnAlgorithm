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
        visited[v]=true;
        Vector<Integer> adjV=G.adj(v);
        Iterator<Integer> it=adjV.iterator();
        while (it.hasNext()){
            int i=it.next();
            if(!visited[i]){
                from[i]=v;
                dfs(i);
            }
        }
    }

    public Path(Graph g,int s){
        this.visited=new boolean[g.V()];
        this.from=new int[g.V()];
        assert s>=0 && s< g.V();
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
        assert hasPath(w);
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

        assert hasPath(w);

        Vector<Integer> vt=getPath(w);
        System.out.println("从"+s+"到"+w+"的路径");
        for (int i : vt){
            System.out.print(i+"\t");
        }
        System.out.println();
    }

}
