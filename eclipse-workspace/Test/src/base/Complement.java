package base;

//Java program to print 1's and 2's complement of 
//a binary number 

//Positive values are stored as it is and negative values are stored in their 
//2’s complement form.
//To get 1's complement, we flip all bits

//To get 2', we normally add 1 to 1's complement
//If all are 1 in 1's complement as in 111 or 11111; 
// in such case, add extra 1 at beginning 
// For example, 2’s complement of “000” is “1000” (1’s complement of “000” is “111”).

class Complement 
{ 

	public static void main(String[] args) 
	{ 
		printOneAndTwosComplement("1100"); 
		
		printOneAndTwosComplement("0011"); 
	} 
		
	// Print 1's and 2's complement of binary number 
	// represented by "bin" 
	static void printOneAndTwosComplement(String bin) 
	{ 
		int n = bin.length(); 
		int i; 

		String ones = "", twos = ""; 

		// for ones complement flip every bit 
		for (i = 0; i < n; i++) 
		{ 
			ones += flip(bin.charAt(i)); 
		} 

		//By below logic, what we did is: Iterate characters starting from end in 1's complement, 
		//if we keep getting 1, we make that 0 and when we get first 0, make that 1 and go out of loop
		//e.g. n=01000,1'=10111, 2'=11000
		twos = ones; 
		for (i = n - 1; i >= 0; i--) 
		{ 
			if (ones.charAt(i) == '1') 
			{ 
				twos = twos.substring(0, i) + '0' + twos.substring(i + 1); 
			} 
			else
			{ 
				twos = twos.substring(0, i) + '1' + twos.substring(i + 1); 
				break; 
			} 
		} 

		// If no break(then i will become -1) i.e. all are 1 in 1's complement as in 111 or 11111; 
		// in such case, add extra 1 at beginning 
		// For example, To get 2’s complement of “000”, (1’s complement of “000” is “111”).
		// Add 1 then 2’s complement is “1000”
		if (i == -1) 
		{ 
			twos = '1' + twos; //1 is already changed to 0 in above loop
		} 

		System.out.println("1's complement: " + ones);; 
		System.out.println("2's complement: " + twos); 
	} 

	// Returns '0' for '1' and '1' for '0' 
	static char flip(char c) 
	{ 
		return (c == '0') ? '1' : '0'; 
	}
	
} 

