package cn.iqcard.graphPractice;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        /*var dg=new DenseGraph(6,false);
        dg.addEdge(1,2);
        dg.addEdge(0,2);
        dg.addEdge(3,5);
        dg.addEdge(3,4);
        dg.addEdge(5,1);
        dg.addEdge(2,4);
        dg.show();*/

        /*SparseGraph sg=new SparseGraph(5,false);
        sg.addEdge(1,2);
        sg.addEdge(1,3);
        sg.addEdge(1,3);
        sg.addEdge(0,2);
        sg.addEdge(0,4);
        sg.addEdge(4,2);
        sg.show();*/

        Vector<Integer>[] g=null;
        g=(Vector<Integer>[]) new Vector[5];
        for(var i=0;i<g.length;i++){
            g[i]=new Vector<Integer>();
        }
        for(var i=0;i<g.length;i++){
            System.out.println(g[i]);
        }

        DenseGraph[] dga=new DenseGraph[5];
    }
}
