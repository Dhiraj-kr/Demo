package java_example.extrinsiclock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

	private List<Integer> lstData=new ArrayList<>();
	
	//lock object is static so its common for all objects
	private final static Lock lock=new ReentrantLock();	
	
	public void add(Integer i) {
		
		if(lstData.size()==0) {
			
			if(lock.tryLock()) {
				System.out.println("Lock acquired by producer");
				lstData.add(i);
				System.out.println("Value added:"+i);
				lock.unlock();
			}
			else {
				System.out.println("Lock not avilable for Producer");
			}
		}
		else {
			System.out.println("Value is already there, wating for consumer to consume");
		}
	}
	
	public void get() {
		
		if(lstData.size()>0) {
			
			if(lock.tryLock()) {
				System.out.println("Lock acquired by consumer");
				Integer i=lstData.get(0);
				lstData.remove(0);
				System.out.println("Value fetched:"+i);
				lock.unlock();
			}
			else {
				System.out.println("Lock is not available for consumer");
			}
			
		}
		else {
			System.out.println("Nothing to get, wating for producer to produce");
		}
	}
	
}
