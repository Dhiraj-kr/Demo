package java_example.synchronizationexample;

import java.util.Random;

public class Producer implements Runnable{

	private SharedResource shared;
	
	Producer(SharedResource shared){
		this.shared=shared;
	}
	public void run() {
		shared.add(new Random().nextInt());
		shared.add(new Random().nextInt());
	}
}
