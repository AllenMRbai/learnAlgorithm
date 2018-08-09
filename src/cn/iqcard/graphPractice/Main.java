package cn.iqcard.graphPractice;

public class Main {
    public static void main(String[] args) {
        System.out.println("DenseGraph 1");
        DenseGraph dg=new DenseGraph(13,false);
        new ReadGraph(dg,dg.getClass().getResource("testG1.txt").getPath());
        Components dg_c=new Components(dg);
        Path dg_p=new Path(dg,0);
        dg.show();
        dg_p.showPath(3);
        System.out.println("连通分量是"+dg_c.getCcount());
        System.out.println("");
        System.out.println("SparseGraph 1");
        SparseGraph sg=new SparseGraph(13,false);
        new ReadGraph(sg,dg.getClass().getResource("testG1.txt").getPath());
        Components sg_c=new Components(sg);
        sg.show();
        System.out.println("连通分量是"+sg_c.getCcount());
        System.out.println("3和6相连吗"+sg_c.isConnected(3,6));
        System.out.println("3和7相连吗"+sg_c.isConnected(3,7));
        System.out.println("7和8相连吗"+sg_c.isConnected(7,8));
        System.out.println("7和12相连吗"+sg_c.isConnected(7,12));

        /*System.out.println("");
        System.out.println("DenseGraph 2");
        DenseGraph dg2=new DenseGraph(6,false);
        new ReadGraph(dg2,dg.getClass().getResource("testG2.txt").getPath());
        dg2.show();
        System.out.println("");
        System.out.println("SparseGraph 2");
        SparseGraph sg2=new SparseGraph(6,false);
        new ReadGraph(sg2,dg.getClass().getResource("testG2.txt").getPath());
        sg2.show();*/


    }
}
