package java.extrinsiclock;

import java.util.Random;

public class Producer implements Runnable{

	private SharedResource shared;
	
	Producer(SharedResource shared){
		this.shared=shared;
	}
	
	public void run() {
		while(true) {
			Random random = new Random();
			shared.add(random.nextInt());
			try {
				Thread.sleep(500l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
