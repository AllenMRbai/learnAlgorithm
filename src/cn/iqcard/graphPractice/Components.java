package cn.iqcard.graphPractice;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Vector;

public class Components {
    private Graph graph;
    private int ccount;
    private int[] id;
    private boolean[] visited;

    private void dfs(int i){
        if(visited[i])
           return;
        visited[i]=true;
        id[i]=ccount;
        Vector<Integer> adj=graph.adj(i);
        Iterator<Integer> it=adj.iterator();
        while (it.hasNext()){
            dfs(it.next());
        }
    }

    public Components(@NotNull Graph graph){
        this.graph=graph;
        this.id=new int[graph.V()];
        this.visited=new boolean[graph.V()];
        ccount=0;

        for(var i=0;i<graph.V();i++){
            if(visited[i])
                continue;
            ccount++;
            dfs(i);
        }
    }

    public int getCcount(){
        return this.ccount;
    }

    public boolean isConnected(int v,int w){
        assert v>=0&&v<graph.V();
        assert w>=0&&w<graph.V();
        return id[v]==id[w];
    }
}
