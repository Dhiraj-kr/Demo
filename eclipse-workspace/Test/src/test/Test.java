package test;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import battleship.Point;

public class Test {

	public static void main(String arg[]) {
		System.out.println("Test Enum:"+ TestEnum.INSTANCE.getValue());
		
		/*
		 * int j =0; List<Continent> continentList=new ArrayList<>();
		 * 
		 * continentList.stream().forEach(e -> {
		 * 
		 * e.setContinentId(j++); });
		 */

		
		int myVar = 42;
	    Supplier<Integer> lambdaFun = () -> myVar; // compile error if below line myVar++ is uncommented 
	    //myVar++;
	    System.out.println(lambdaFun.get());
	    
	    BinaryOperator<Integer> 
        op = BinaryOperator 
                 .maxBy( 
                     (a, b) -> (a > b) ? 1 : ((a == b) ? 0 : -1)); 
	    
	    //static <T> BinaryOperator<T>	maxBy(Comparator<? super T> comparator)
	    //Returns a BinaryOperator which returns the greater of two elements according to the specified Comparator.

	    System.out.println(op.apply(98, 11)); 

	    
		System.out.print("input: ");
		System.out.flush();
		Scanner s=null;
		try {
			s = new Scanner(System.in);
			String token;
			do {
				token = s.findInLine("ab");
				System.out.println("found " + token);
			} while (token != null);
		} catch (Exception e) { 
			System.out.println("scan exception"); 
		}
		s.close();
		
		
		String s1 = "abc";
		String s2 = s1;
		s1 += "d";
		System.out.println(s1 + " " + s2 + " " + (s1==s2));
		
		StringBuffer sb1 = new StringBuffer("abc");
		StringBuffer sb2 = sb1;
		sb1.append("d");
		System.out.println(sb1 + " " + sb2 + " " + (sb1==sb2));


		
		float f1 = 123.4567f;
		Locale locFR = new Locale("fr"); // France
		NumberFormat[] nfa = new NumberFormat[4];
		nfa[0] = NumberFormat.getInstance();
		nfa[1] = NumberFormat.getInstance(locFR);
		nfa[2] = NumberFormat.getCurrencyInstance();
		nfa[3] = NumberFormat.getCurrencyInstance(locFR);
		for(NumberFormat nf : nfa)
		System.out.println(nf.format(f1));

		Pattern p = Pattern.compile("\\d*");
		Matcher m = p.matcher("ab34ef");
		boolean b = false;
		while(b = m.find()) {
		System.out.println(m.start() +" "+ m.group());
		}

		System.out.println("----------");
		
		List<Integer> lst1=new ArrayList<>();
		List<Integer> lst2=new ArrayList<>();
		lst1.add(1);
		lst1.add(2);
		lst1.add(3);
		lst1.add(4);
		
		lst2.add(5);
		lst2.add(6);
		lst2.add(3);
		lst2.add(4);
		
		List<Integer> lst3=new ArrayList<>();
		//lst2=lst3;
		
		lst1.stream().filter(i->!lst2.contains(i)).forEach(System.out::println);
		
		Employee e0=new Employee("ABC",3);
		Employee e1=new Employee("DEF",4);
		Employee e2=new Employee("GHI",5);
		
		List<Employee> lstEmp=new ArrayList<>();
		lstEmp.add(e0);
		lstEmp.add(e1);
		lstEmp.add(e2);
		
		lstEmp=null;
		List<Employee> lstEmp2=new ArrayList<>();
		lstEmp2.addAll(lstEmp);
		
		/*
		 * if(lstEmp.isEmpty()) { System.out.println("abc"); }
		 */
		
		//lstEmp.parallelStream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge)).forEachOrdered(System.out::println);;
		Comparator<Employee> compareByName = Comparator.comparing(emp -> emp.getName());
		Comparator<Employee> compareByAge = Comparator.comparing(emp -> emp.getAge());
		lstEmp.parallelStream().sorted(compareByName.thenComparing(compareByAge)).forEachOrdered(System.out::println);;
		
		List<Integer> lst=new ArrayList<>();
		
		Map<String, Integer> itemToPrice=new HashMap<>();
		//itemToPrice
		
		Map<String, Integer> sortedByPrice = itemToPrice.entrySet() .stream() .sorted(Map.Entry.<String, Integer>comparingByValue()) .collect(Collectors.toMap(e -> e.getKey(),e -> e.getValue()));

		Object obj="abc";
		System.out.println("Test:::"+obj.equals("abc"));
		
		lst=null;
		for(Integer i: lst) {
			System.out.println(i);
		}
		
		
		
		//lst.add(1, 2);	//throws Indexoutofbounds
		lst.add(0, 2);
		lst.add(null);
		lst.add(4);
		lst.add(null);
		lst.add(4);
		for(Integer i:lst) {
			System.out.println(i);
		}
		System.out.println("--------");
		lst=m1(lst);
		Iterator<Integer> it=lst.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	  Point pnt1 = new Point(0,0);
	  Point pnt2 = new Point(0,0);
	  System.out.println("X: " + pnt1.x + " Y: " +pnt1.y); 
	  System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);
	  System.out.println(" ");
	  tricky(pnt1,pnt2);
	  
	  try {
		  System.out.println("Hello");
	  }
	  catch(Exception ex) {
		  
	  }
		
		 // pnt1.x = 100; pnt1.y = 100; Point temp = pnt1; pnt1 = pnt2; pnt2 = temp;
		 
	  
		
		  System.out.println("X: " + pnt1.x + " Y:" + pnt1.y); //100,100
		  System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);
		 
		
		/*
		 * try { int x=5/0; } catch(IllegalArgumentException e){
		 * 
		 * }
		 * 
		 * 
		 * catch(IOException e) { e.printStackTrace(); }
		 */
		 
	  List<A>      listA      = new ArrayList<A>();
	  insertElements(listA);

	  List<Object> listObject = new ArrayList<Object>();
	  insertElements(listObject);

	}
	
	public static void insertElements(List<? super A> list){
	    list.add(new A());
	    //list.add(new B());
	    list.add(new C());
	}
	
	public static List<Integer> m1(List<Integer> lst) {
		lst.add(3);
		return lst;
	}
	
	public static void tricky(Point arg1, Point arg2)
	{
	  arg1.x = 100;
	  arg1.y = 100;
	  Point temp = arg1;
	  arg1 = arg2;
	  arg2 = temp;
	  System.out.println("X: " + arg1.x + " Y: " +arg1.y); 
	  System.out.println("X: " + arg2.x + " Y: " +arg2.y);
	}
}

class A1 { }
class B1 extends A1 {
public static void main (String [] args) {
A1 myA = new B1();
m2(myA);
}
public static void m2(A1 a) {
if (a instanceof B1)
((B1)a).doBstuff(); // down casting an A reference to a B reference
}
public static void doBstuff() {
System.out.println("'a' refers to a B");
}
}




class Continent{
	int continentId;

	public int getContinentId() {
		return continentId;
	}

	public void setContinentId(int continentId) {
		this.continentId = continentId;
	}
	
}