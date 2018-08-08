package cn.iqcard.graphPractice;

import java.util.Vector;

public interface Graph {
    public int V();
    public int E();
    public void addEdge( int v , int w );
    boolean hasEdge( int v , int w );
    void show();
    public Vector<Integer> adj(int v);
}
