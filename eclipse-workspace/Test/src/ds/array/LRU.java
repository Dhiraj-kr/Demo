package ds.array;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class LRU {

	static Deque<Integer> dq;   
    //maximum capacity of cache  
    static int csize; 
      
    LRU(int n) 
    { 
        dq=new LinkedList<>(); 
        csize=n; 
    } 
      
    /* Refers key x with in the LRU cache */
    public void refer(int x) 
    { 
        if(!dq.contains(x)) 
        { 
            if(dq.size()==csize) 
            { 
                dq.removeLast(); 
            } 
        } 
        else
        { 
            dq.remove(x); 
        } 
        dq.push(x); 
        System.out.print("---"); 
        display();
    } 
      
    // display contents of cache  
    public void display() 
    { 
        Iterator<Integer> itr = dq.iterator(); 
        while(itr.hasNext()) 
        { 
            System.out.print(itr.next()+" "); 
        } 
    } 
      
      
    public static void main(String[] args) { 
        LRU ca=new LRU(4); 
        ca.refer(1);  
        ca.refer(2);  
        ca.refer(3);  
        ca.refer(1);  
        ca.refer(4);  
        ca.refer(5);  
        //ca.display();      
    } 
}
