package cn.iqcard.graphPractice;

import java.util.ListIterator;
import java.util.Vector;

public class SparseGraph implements Graph{
    int n;
    int m;
    boolean directed;
    Vector<Vector<Integer>> g;

    public SparseGraph(int v,boolean directed){
        this.n=v;
        this.m=0;
        this.directed=directed;

        g=new Vector<Vector<Integer>>(v);

        for(var i=0;i<v;i++){
            g.add(new Vector<Integer>());
        }
    }

    public int V(){
        return this.n;
    }

    public int E(){
        return this.m;
    }

    //添加边
    public void addEdge(int v,int w){
        assert v>=0&&v<this.n;
        assert w>=0&&w<this.n;

        if(!this.hasEdge(v,w)){
            g.get(v).add(w);
            if(!this.directed){
                g.get(w).add(v);
            }
            this.m++;
        }

    }

    //验证v和w是否相连
    public boolean hasEdge(int v,int w){
        assert v>=0&&v<this.n;
        assert w>=0&&w<this.n;

        ListIterator it=g.get(v).listIterator();
        while (it.hasNext()){
            var tmp=it.next();
            if(tmp.equals(w)){
                return true;
            }
        }
        return false;
    }

    //打印图
    public void show(){
        ListIterator it=g.listIterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    //返回一个节点的所有邻边
    public Vector<Integer> adj(int v){
        assert v>=0&&v<n;
        return g.get(v);
    }
}
