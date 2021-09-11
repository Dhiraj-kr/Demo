package java.genericsexample;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		List<NaturalNumber> ln = new ArrayList<>();
		List<EvenNumber> le = new ArrayList<>();
		
		//ln=le;	//Compile time error.
		//le=ln;	//Compile time error.
		
		List<? extends NaturalNumber> ln1 = le;
		
		//ln1.add(new NaturalNumber(35)); //Compile time error. Due to capturing.
		//ln1.add(new EvenNumber(35));  //Compile time error
		ln.add(null);
	}
	
	class NaturalNumber {

	    private int i;

	    public NaturalNumber(int i) { this.i = i; }
	    // ...
	}

	class EvenNumber extends NaturalNumber {

	    public EvenNumber(int i) { super(i); }
	    // ...
	}

}
