package java_example.synchronizationexample;

public class Consumer implements Runnable{

	private SharedResource shared;
	
	Consumer(SharedResource shared){
		this.shared=shared;
	}
	public void run() {
		System.out.println("Value in consumer :"+shared.get());
		System.out.println("Value in consumer :"+shared.get());
	}
}
