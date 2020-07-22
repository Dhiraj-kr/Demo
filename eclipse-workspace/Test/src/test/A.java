package test;

import java.util.HashSet;
import java.util.Set;

class B { 
	int i; 
}
public class A { 
	
	public static void main(String arg[]) {
		B b=new B();
		System.out.println(b.i);
		
		Set<String> set=new HashSet<>();
		set.add(null);
		set.add(null);
		set.forEach(System.out::println);
	}
}

class C extends A { }
