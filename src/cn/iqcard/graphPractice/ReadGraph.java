package cn.iqcard.graphPractice;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ReadGraph {
    private Scanner scanner;

    public ReadGraph(Graph graph,String filename){
        readFile(filename);

    }

    private void readFile(String filename) {
        assert filename !=null;
        try{
            File file=new File(filename);
            if(file.exists()){
                FileInputStream fis=new FileInputStream(file);
                scanner=new Scanner(new BufferedInputStream(fis),"UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            }else
                throw new IllegalArgumentException(filename+"doesn't exist");
        }catch (IOException ioe){
            throw new IllegalArgumentException("Could not open "+filename,ioe);
        }
    }

}
