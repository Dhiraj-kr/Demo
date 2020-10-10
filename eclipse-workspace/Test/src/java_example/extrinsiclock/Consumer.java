package java_example.extrinsiclock;

public class Consumer implements Runnable{

	private SharedResource shared;
	
	Consumer(SharedResource shared){
		this.shared=shared;
	}
	public void run() {
		while(true) {
			shared.get();
			try {
				Thread.sleep(500l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
