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
		//catch(IOException  | Exception ex){
		catch(Exception ex){
		     System.out.print(ex);
		     throw new MyException(ex.getMessage());
		}
		
		finally {
			return 1;
		}
	}
}
