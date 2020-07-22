package test;

	import java.util.ArrayList;
	import java.util.List;

	public class GenericTest {

	    class Animal {}
	    class Dog extends Animal {}
	    class Cat extends Animal {}

	    List<? extends Animal> getAnimals() {
	        return new ArrayList<>();
	    }

	    //If I return a List<? extends Animal> it explicitly means that this is a list of some Animal class, 
	    //but the caller does not know if it's a list of List<Dog>, List<Cat>, etc., 
	    //so the compiler does not allow adding any elements except for null, which is always valid.
	    void check() {
	        //getAnimals().add(new Dog()); // does not compile
	        //getAnimals().add(new Cat()); // does not compile
	        //getAnimals().add(new Animal()); // does not compile
	        getAnimals().add(null); // OK
	    }
	    
	    List<Animal> getAnimals1() {
	        return new ArrayList<>();
	    }

	    void check1() {
	        getAnimals1().add(new Dog()); // OK
	        getAnimals1().add(new Cat()); // OK
	        getAnimals1().add(new Animal()); // OK
	        getAnimals1().add(null); // OK
	    }
	}