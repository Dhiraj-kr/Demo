package java.concurrentexample;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {
  
    private int count;
    AtomicInteger atomicCount = new AtomicInteger( 0 );

  
    /*
     * This method thread-safe now because of locking and synchornization
     */
    public synchronized int getCount(){
        return count++;
    }
  
    /*
     * This method is thread-safe because count is incremented atomically
     */
    public int getCountAtomically(){
        return atomicCount.incrementAndGet();
    }
}

