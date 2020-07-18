package test;

public class TryTest {

	public static void main(String arg[]) {
		TryTest tryTest=new TryTest();
		System.out.println(tryTest.test());
	}
	
	private int test() {
		try {
			return 0;
		}
		finally {
			return 1;
		}
	}
}
