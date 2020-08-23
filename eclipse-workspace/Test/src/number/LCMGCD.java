package number;
/*
 
 LCM(Least Common Multiple) is the smallest positive number which is divisble by both the numbers. For example lcm of 8 and 12 is 24 as 24 is divisble by both 8(8*3) and 12(12*2). 
HCF(Highest Common Factor)/GCD(Greatest Common Divisor) is the largest positive integer which divides each of the two numbers.
GCD of 2 and 4 is
4=2*2
6=2*3
Common is 2 so GCD or HCF is 2
6/4= Remainder 2 ; 6 is numerator and 4 is denominator
4/2, in this steps, denominator becomes numerator and remainder becomes denominator
Keep on dividing until remainder is 0.
GCD=2
LCM -> n1*n2/GCD
LCM: 6*4/2=12  

 
 */

public class LCMGCD {
	public static void main(String arg[])
	{
	    int n1=8,n2=6;
	    int gcd,lcm,remainder,numerator,denominator;
	 
	    if (n1>n2)
	    {
	        numerator=n1;
	        denominator=n2;
	    }
	    else
	    {
	        numerator=n2;
	        denominator=n1;
	    }
	    remainder=numerator%denominator;
	    while(remainder!=0)
	    {
	        numerator=denominator;
	        denominator=remainder;
	        remainder=numerator%denominator;
	    }
	    gcd = denominator;	
	    lcm = n1*n2/gcd;
	    System.out.printf("GCD of %d and %d = %d\n",n1,n2,gcd);
	    System.out.printf("LCM of %d and %d = %d\n",n1,n2,lcm);
	}

}
