package java_example.genericsexample;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class A { /* ... */
	static <T,U> U pick(T a1, U a2) { 
		System.out.println(a1);
		return a2; 
	}
	static <T> T pick2(T a1, T a2) { 
		System.out.println(a1);
		return a2; 
	}
	static <T> void pick3(T a1, T a2) { 
		System.out.println(a1);
		System.out.println(a2);
	}
}
interface B { /* ... */ }
interface C { /* ... */ }

class D <T extends A & B & C> { /* ... */ }

class E{}
//class F <T extends A & E & C> { /* ... */ }	//Compiler Error

public class Box<T> {

    private T t;          

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    	
    	Box rawBox = new Box();
    	
    	Box<Integer> intBox = new Box<>();
    	Box rawBox1 = intBox;               // OK
    	rawBox1.set("abc");  				//Warning and you can put whatever type, no type safety
    	
    	intBox=rawBox;	//Warning
    	//intBox.set("abc");  				//Compile error
    	
    	List<A1> listA = new ArrayList<A1>();
    	processElements(listA);
    	
    	List<B1> listB = new ArrayList<B1>();
    	processElements1(listB);
    	
    	insertElements(listA);

    	List<Object> listObject = new ArrayList<Object>();
    	insertElements(listObject);
    	
    	foo(listA);
    	
    	String string   = getInstance(String.class);
    	System.out.println(string);

    	A1 myClass = getInstance(A1.class);
    	System.out.println(myClass);
    	
    	List<?> lst=new ArrayList<>();
    	lst.add(null);
    	//lst.add(string);//compile time error
    	
    	List<Object> lst1=new ArrayList<>();
    	lst1.add(null);
    	lst1.add(string);

    	Object ob=null;
    	System.out.println("ob is: "+String.valueOf(ob));
    	if(null==null) {
    		System.out.println("null == null");
    	}
    	//System.out.println(String.valueOf(null));//Null Pointer Exception
    	
        Box<Integer> integerBox = new Box<>();
        integerBox.set(10);
        List<String> lst2 = A.pick("d", List.of("abc"));
        System.out.println(lst2);
        
        lst2 = A.pick("d", Arrays.asList("abc"));
        System.out.println(lst2);
        
        //Because List does not implement Serializable but ArrayList implement Serializable
        Serializable s = A.pick2("d", new ArrayList<>(Arrays.asList(1,2,3)));	
        System.out.println(s);
        
        Object o = A.pick2("d", Arrays.asList(1,2,3));
        
        A.pick3("d", Arrays.asList(1,2,3));
        //integerBox.inspect("some text"); // Compilation error because inspect method expects subclass of Number
    }
    
    public static <T> T getInstance(Class<T> theClass)
    	    throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

    	   return theClass.getDeclaredConstructor(null).newInstance();
    }
    
    static void foo(List<?> i) {
        //i.set(0, i.get(0));//compile time error
        fooHelper(i);
    }
    private static <T> void fooHelper(List<T> l) {
        l.set(0, l.get(0));
    }

    public <U extends Number> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }
    
    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)
                ++count;
        return count;
    }
    
    public static void processElements(List<?> elements){
	   for(Object o : elements){
	      System.out.println(o);
	   }
    }
    
    public static void processElements1(List<? extends A1> elements){
	   for(A1 a : elements){
	      System.out.println(a.getValue());
	   }
	   //elements.add(new A1());//Compile time error because user won't know which type of object is added
	   //elements.add(new B1());//Same as above
	   //elements.add(new C1());//Same as above

    }
    
    public static void insertElements(List<? super A1> elements){
 	   elements.add(new A1());
 	   elements.add(new B1());
 	   elements.add(new C1());
 	   //elements.add(new Object());	//Compile time error, we can't add Object obj
 	   
 	   for(Object a : elements){
 		  System.out.println(a.toString());
  	      System.out.println(((A1) a).getValue());
  	   }

     }
}

class NaturalNumber<T extends Number> {

    private T n;

    public NaturalNumber(T n)  { this.n = n; }

    public boolean isEven() {
        return n.intValue() % 2 == 0;
    }

    // ...
}

class A1 {

	public String getValue() {
		return "abc";
	} 
}
class B1 extends A1 { }
class C1 extends A1 { }
