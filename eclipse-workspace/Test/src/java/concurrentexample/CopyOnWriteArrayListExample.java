package java.concurrentexample;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
	
	public static void main(String arg[]) {
		
		CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<>();
		list.add("abc");
		list.add("bcd");
		Iterator<String> it=list.iterator();
		
		while(it.hasNext()) {
			String str=it.next();
			if("abc".equals(str)) {
				it.remove();
			}
		}
		
		list.forEach(System.out::println);
	}

}
