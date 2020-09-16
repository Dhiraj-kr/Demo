package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class LineOrderingByLength {
 
    public static void main(String[] args) {
         
        BufferedReader br = null;
        String line;
        String filePath = args[0];
        Set<Entries> liSet = new TreeSet<Entries>(new MyComp());
        try {
            br = new BufferedReader(new FileReader(new File(filePath)));
            
            while((line = br.readLine()) != null){
                line = line.trim();
                if(!"".equals(line)){
                    liSet.add(new Entries(line.length(), line));
                }
            }
            
            for(Entries ent:liSet){
                System.out.println(ent.line);
                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public static class Entries{
        Integer length;
        String line;
        public Entries(Integer l,String line){
            length = l;
            this.line = line;
        }
    }
     
    public static class MyComp implements Comparator<Entries>{
 
        @Override
        public int compare(Entries e1, Entries e2) {
            if(e2.length > e1.length){
                return 1;
            } else {
                return -1;
            }
        }
         
    }
}


/*
Input file:  

Java2novice
My Test line 123

Java world
I know java language

This is a test program
java is simple

Output:

This is a test program
I know java language
My Test line 123
java is simple
java2novice
java world
*/