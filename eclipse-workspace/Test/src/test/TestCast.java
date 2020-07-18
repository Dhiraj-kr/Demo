package test;

import java.util.Date;

class Animal { }
class Dog extends Animal { }


public class TestCast {

	public static void main(String arg[]) {
		
		Date date;
		if (date == null)
			System.out.println("date is null");

		
		Test t1 = new Test();
		Test t2 = new Test();
		if (!t1.equals(t2))
			System.out.println("they're not equal");
		
		if (t1 instanceof Object)
			System.out.println("t1's an Object");
		
		Animal animal = new Animal();
		Dog d = (Dog) animal; // compiles but fails later
	}
}
