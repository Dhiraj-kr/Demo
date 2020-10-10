package java_example.immutable;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

class Test 
{ 
    public static void main(String args[]) 
    { 
        Student s = new Student("ABC", 101); 
        System.out.println(s.getName()); 
        System.out.println(s.getRegNo()); 
  
        // Uncommenting below line causes error 
        // s.regNo = 102; 
        Student s1=null;
        Optional<Student> op = Optional.ofNullable(s);
        System.out.println(op.get());
        
        op.ifPresent(System.out::println);
        op.ifPresent((ss)->System.out.println("--"+ss));
        
        //op = Optional.of(s1);	//Null pointer exception 
        op = Optional.ofNullable(s1);
        System.out.println(op.orElse(s));
        
        op = Optional.empty(); 
        //System.out.println(op.get());	//Nosuchelementexception i.e. run time exception
        
        try {
			op.orElseThrow(Exception::new);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        try {
        	test(op);
        } catch (Exception e) {
			e.printStackTrace();
		}
        
        op = Optional.ofNullable(s);
        System.out.println("Optional::"+op);
        op.filter(student -> "ABC".equals(student.getName())).ifPresent((s2) -> System.out.println("Live in NewYork"));
        
        Set<Student> set=new TreeSet<>();
        set.add(s);
        

    } 
    
    static void test(Optional<Student> op)  {
		try {
			op.orElseThrow(NullPointerException::new);
		} 
		catch (final NullPointerException e) {
			e.printStackTrace();
			throw e;
		}catch (final Throwable e) {
			e.printStackTrace();
			throw e;
		}
    }
} 