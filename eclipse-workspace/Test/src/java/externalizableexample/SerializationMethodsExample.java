package java.externalizableexample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Objects;

public class SerializationMethodsExample {
	
	static class Employee implements Serializable, ObjectInputValidation {
	    
		private static final long serialVersionUID = 2L;
		
	    private String name;
	    private int age;
	    
	    public Employee(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }
	    // With ObjectInputValidation interface we get a validateObject method where we can do our validations.
	    @Override
	    public void validateObject() {
	    	
	        System.out.println("Validating age.");
	        if (age < 18 || age > 70)
	        {
	            throw new IllegalArgumentException("Not a valid age to create an employee");
	        }
	    }
	    // Custom serialization logic,
	    // This will allow us to have additional serialization logic on top of the default one e.g. encrypting object before serialization.
	    private void writeObject(ObjectOutputStream oos) throws IOException {
	        
	    	System.out.println("Custom serialization logic invoked.");
	        oos.defaultWriteObject(); // Calling the default serialization logic
	    }
	    // Replacing de-serializing object with this,
	    private Object writeReplace() throws ObjectStreamException {
	        
	    	System.out.println("Replacing serialising object by this.");
	        return this;
	    }
	    // Custom deserialization logic
	    // This will allow us to have additional deserialization logic on top of the default one e.g. performing validations, decrypting object after deserialization.
	    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
	        
	    	System.out.println("Custom deserialization logic invoked.");
	        ois.registerValidation(this, 0); // Registering validations, So our validateObject method can be called.
	        ois.defaultReadObject(); // Calling the default deserialization logic.
	    }
	    // Replacing de-serializing object with this,
	    // It will will not give us a full proof singleton but it will stop new object creation by deserialization.
	    private Object readResolve() throws ObjectStreamException {
	        
	    	System.out.println("Replacing de-serializing object by this.");
	        return this;
	    }
	    @Override
	    public String toString() {
	        return String.format("Employee {name='%s', age='%s'}", name, age);
	    }
	}
	
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    	
        Employee emp = new Employee("Naresh Joshi", 25);
        System.out.println("Object before serialization: " + emp.toString());
        
        // Serialization
        serialize(emp);
        
        // Deserialization
        Employee deserialisedEmp = deserialize();
        
        System.out.println("Object after deserialization: " + deserialisedEmp.toString());
        System.out.println();
        // This will print false because both object are separate
        System.out.println(emp == deserialisedEmp);
        System.out.println();
        // This will print false because both `deserialisedEmp` and `emp` are pointing to same object,
        // Because we replaced de-serializing object in readResolve method by current instance
        System.out.println(Objects.equals(emp, deserialisedEmp));
    }
    // Serialization code
    static void serialize(Employee empObj) throws IOException {
        
    	try (FileOutputStream fos = new FileOutputStream("data.obj");
             ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(empObj);
        }
    }
    // Deserialization code
    static Employee deserialize() throws IOException, ClassNotFoundException {
        
    	try (FileInputStream fis = new FileInputStream("data.obj");
             ObjectInputStream ois = new ObjectInputStream(fis))
        {
            return (Employee) ois.readObject();
        }
    }
}