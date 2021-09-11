package java.immutable;

public final class Student //Class should not be inherited
{ 
	//Instance variables should be final
    final String name; 	
    final int regNo; 
  
    public Student(String name, int regNo) 
    { 
    	//Initialize final variables in constructors
        this.name = name; 
        this.regNo = regNo; 
    } 
    public String getName() 
    { 
        return name; 
    } 
    public int getRegNo() 
    { 
        return regNo; 
    } 
    //No setters
    public String toString() {
    	return name+","+regNo;
    }
} 