package test;

class B { 
	int i; 
}
public class A { 
	
	public static void main(String arg[]) {
		B a=new B();
		System.out.println(a.i);	
	}
}

class C extends A { }
