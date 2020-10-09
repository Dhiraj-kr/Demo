package concurrent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestBarrierFile {

	public static void main(String arg[]) throws FileNotFoundException {
	    
		CyclicBarrier cb=new CyclicBarrier(3,(
			()->System.out.println("Barrier Reached"))
		);
		
		File f = new File(TestBarrier.class.getClassLoader().getResource("abc.txt").getFile());
		/*
		getClass is non static method in Object class, can't call from static method
		File f = new File(getClass().getClassLoader().getResource("abc.txt").getFile());
		*/

		BufferedReader br = new BufferedReader(new FileReader(f));
		
		WorkerThread w1 = new WorkerThread(br, cb); 
		WorkerThread w2 = new WorkerThread(br, cb); 
		WorkerThread w3 = new WorkerThread(br, cb);
		 
		new Thread(w1, "Thread 1").start();
		new Thread(w2, "Thread 2").start();
		new Thread(w3, "Thread 3").start();
	}
}

class WorkerThread implements Runnable {
	BufferedReader br;
	CyclicBarrier cb;

	public WorkerThread(BufferedReader br, CyclicBarrier cb) {
		super();
		this.br = br;
		this.cb = cb;
	}

	public void run() {
		String str = null;
		
		do{
			try {
				str = br.readLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() +"  "+str);
			try {
				int c = cb.await();
				System.out.println(Thread.currentThread().getName() + " await returned");

				if (c == 2) {
					break;
				}

			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}while (str != null) ;
		if (str == null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
