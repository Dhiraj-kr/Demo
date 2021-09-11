package java_example.synchronizationexample;

public class Main {

	public static void main(String[] args) {

		SharedResource resource=new SharedResource();
		Producer producer=new Producer(resource);
		Consumer consumer=new Consumer(resource);
		
		Thread t1=new Thread(producer);
		Thread t2=new Thread(consumer);
		t2.setPriority(Thread.NORM_PRIORITY);
		t1.setPriority(Thread.NORM_PRIORITY);
		t1.start();
		t2.start();
	}

}
