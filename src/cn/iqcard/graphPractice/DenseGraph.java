package cn.iqcard.graphPractice;

import java.util.Vector;

//稠密图 - 邻接矩阵
public class DenseGraph implements Graph{
    private int n;//节点数
    private int m;//边数
    private boolean directed; //是否是有向图
    private boolean[][] g;//图的具体数据

    //构造函数
    public DenseGraph(int v,boolean directed){
        assert v>=0;
        this.n=v;
        this.m=0;
        this.directed=directed;
        g=new boolean[n][n];
    }

    //返回节点数
    public int V(){
        return n;
    }

    //返回边数
    public int E(){
        return m;
    }

    //添加一条边
    public void addEdge(int v,int w){
        assert v>=0&&v<this.n;
        assert w>=0&&w<this.n;

        if(this.hasEdge(v,w))
            return;

        this.g[v][w]=true;
        if(!this.directed)
            this.g[w][v]=true;

        this.m++;
    }

    //验证v和w是否相连
    public boolean hasEdge(int v,int w){
        assert v>=0&&v<this.n;
        assert w>=0&&w<this.n;

        return g[v][w];
    }

    //打印图
    public void show(){
        int len=this.g.length;
        String tmp=" ";
        if(len>20){
            System.out.println("长度超过20，不方便输出");
            return;
        }
        for(int i=0;i<len;i++){
            tmp+=" "+(i);
        }
        System.out.println(tmp);
        for(int x=0;x<len;x++){
            tmp=(x)+"";
            for(int y=0;y<len;y++){

                tmp+=" "+(g[x][y]==true?1:0);
            }
            System.out.println(tmp);
        }
    }

    //返回一个节点的所有邻边
    public Vector<Integer> adj(int v){
        assert v>=0&&v<n;
        Vector<Integer> adjV=new Vector<Integer>();
        for(var i=0;i<g[v].length;i++){
            if(g[v][i])
                adjV.add(i);
        }
        return adjV;
    }
}
