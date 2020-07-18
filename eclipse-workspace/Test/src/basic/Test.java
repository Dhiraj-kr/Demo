package basic;

interface Parent{
	void bar();
	String toString();
}


public class Test implements Parent{
	
	public void foo() {
		
	}
	public void bar() {
		
	}

	public static void main(String arg[]) {
		Parent p = new Test();
		System.out.println(p.toString());
		//p.foo();//compiler error
		//Test2 test2=(Test2) new Test();//run time exception: class cast exception
		Test3 test3=new Test3();
		System.out.println(test3.i);
	}
}
class Test2 extends Test{
	
}
