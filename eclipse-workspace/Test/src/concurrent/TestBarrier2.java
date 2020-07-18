package concurrent;

import java.io.FileNotFoundException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class TestBarrier2 {

	public static void main(String arg[]) throws FileNotFoundException {
	    
		CyclicBarrier cb=new CyclicBarrier(3,(
			()->System.out.println("Barrier Reached"))
		);
		
		AtomicInteger ai=new AtomicInteger(); 
		Worker w1 = new Worker(cb, ai, 1);
		Worker w2 = new Worker(cb, ai, 2); 
		Worker w3 = new Worker(cb, ai, 3);
		 
		new Thread(w1, "Thread 1").start();
		new Thread(w2, "Thread 2").start();
		new Thread(w3, "Thread 3").start();
	}
	
	static class Worker implements Runnable {
		CyclicBarrier cb;
		volatile int count;
		AtomicInteger ai;
		AtomicInteger ai2=new AtomicInteger();

		public Worker(CyclicBarrier cb, AtomicInteger ai, int count) { 
			 super(); 
			 
			 this.cb = cb;
			 this.count=count; 
			 
			 this.ai=ai;
			 ai.set(count); 
			 
			 this.ai2=ai;
			 ai2.set(count); 
		}
		 

		public void run() {
			while (true) {
				
				System.out.println(Thread.currentThread().getName() +" before incrementing : "+ai.get());
				ai.set(ai.get()+3);
				System.out.println(Thread.currentThread().getName() +" after incrementing : "+ai.get());
				try {
					int c = cb.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " await returned");
				if(ai.get()>=10) {
					cb.reset();
					break;
				}
			}
		}
	}
}

