package ds.string;

public class Reverse {

	public static void main(String arg[]) {
		
		String str="dheeraj";
		reverse1(str);
		System.out.println(recLen(str));
		System.out.println(reverse2(str));
		System.out.println(reverse3(str));
		
	}
	
	//Recursion
	static void reverse1(String str) 
    { 
        if ((str==null)||(str.length() <= 1)) 
           System.out.println(str); 
        else
        { 
            System.out.print(str.charAt(str.length()-1)); 
            reverse1(str.substring(0,str.length()-1)); 
        } 
    } 

	public static String reverse2(String str)
    {
        if (str.isEmpty())
            return str;
        return reverse2(str.substring(1)) + str.charAt(0);
    }
	
	//Iteration
	public static String reverse3(String str)
    {
		char[] chArr=str.toCharArray();
		int n=chArr.length;
        for(int i=0;i<n/2;i++) {
        	//swap(chArr[i],chArr[n-i-1]);	//Using this, swapping will not be done as its passed by value
        	char temp=chArr[i];
        	chArr[i]=chArr[n-i-1];
        	chArr[n-i-1]=temp;
        }
        return String.valueOf(chArr);
    }
	
	/*
	 * private static void swap(char c, char d) { char temp=c; c=d; d=temp; }
	 */

	private static int recLen(String str)  
    { 
  
        // if we reach at the end of the string 
        if (str.equals("")) 
            return 0; 
        else
            return recLen(str.substring(1)) + 1; 
    } 


}
