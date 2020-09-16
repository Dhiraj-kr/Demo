package number;

public class EvenOdd {
	// A simple Java program to 
	// check for even or odd 

		// Returns true if n 
		// is even, else odd 
		static boolean isEven(int n) 
		{ 
			boolean isEven = true; 
			
			for (int i = 1; i <= n; i++) 
				isEven = !isEven; 
				
			return isEven; 
		} 
		
		static boolean isEven2(int n) 
		{ 
		      
		    // Return true if  
		    // n/2 does not result 
		    // in a float value. 
		    return ((n >> 2) << 2 == n); 
		} 
		
		public static void main(String args[]) 
		{ 
			
			int n = 101; 
			if(isEven(n)) 
				System.out.println("Even"); 
			else
				System.out.println("Odd"); 
			
			if(isEven2(n)) 
				System.out.println("Even"); 
			else
				System.out.println("Odd");
			
		} 
	} 
