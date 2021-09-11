package java.extrinsiclock;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		SharedResource resource=new SharedResource();
		Producer producer=new Producer(resource);
		Consumer consumer=new Consumer(resource);
		
		//Change flags to check both behaviors
		boolean flag=true;
		
		if(flag) {
			(new Thread(producer)).start();
			(new Thread(consumer)).start();
		}
		else {
			//No need for Producer and Consumer threads
			(new Thread(()->
				{
					for(int i=0;i<20;i++) {
						Random random = new Random();
						resource.add(random.nextInt());
						try {
							Thread.sleep(500l);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			)).start();
			
			(new Thread(()->
				{
					for(int i=0;i<20;i++) {
						resource.get();
						try {
							Thread.sleep(500l);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			)).start();
		}
	}

}
