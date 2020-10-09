package synchronization;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {

	private List<Integer> lstData=new ArrayList<>();

	public synchronized void add(Integer i) {
		if(lstData.size()==0) {
			lstData.add(i);
			notify();
			System.out.println("Value added, Notification from add");
		}
		else {
			while(lstData.size()>0) {
				try {
					System.out.println("Going to call wait from add");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Returned from wait from add");
			}
		}
		System.out.println("Returning from add");
	}
	
	public synchronized Integer get() {
		if(lstData.size()>0) {
			Integer i=lstData.get(0);
			lstData.remove(0);
			notify();
			System.out.println("Value fetched: "+i+", Notification from get");
			return i;
		}
		else {
			while(lstData.size()==0) {
				try {
					System.out.println("Going to call wait from get");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Returned from wait from get");
			}
		}
		System.out.println("Returning -1 from get");
		return -1;
	}
	
}
