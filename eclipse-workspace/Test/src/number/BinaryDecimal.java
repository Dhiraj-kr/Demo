package number;

import java.util.Stack;

/*
 
 Decimal to Hexadecimal:
->ASCII of 0 is 48, A is 65 and a is 97

Store the remainder when the number is divided by 16 in a temporary variable temp. If temp is less than 10, insert (48 + temp) in a character array otherwise if temp is greater than or equals to 10, insert (55 + temp) in the character array.
If the given decimal number is 2545.
Step 1: Calculate remainder when 2545 is divided by 16 is 1. Therefore, temp = 1. As temp is less than 10. So, arr[0] = 48 + 1 = 49 = ‘1’.
Step 2: Divide 2545 by 16. New number is 2545/16 = 159.
Step 3: Calculate remainder when 159 is divided by 16 is 15. Therefore, temp = 15. As temp is greater than 10. So, arr[1] = 55 + 15 = 70 = ‘F’.
Step 4: Divide 159 by 16. New number is 159/16 = 9.
Step 5: Calculate remainder when 9 is divided by 16 is 9. Therefore, temp = 9. As temp is less than 10. So, arr[2] = 48 + 9 = 57 = ‘9’.
Step 6: Divide 9 by 16. New number is 9/16 = 0.
Step 7: Since number becomes = 0. Stop repeating steps and print the array in reverse order. Therefore the equivalent hexadecimal number is 9F1.

 
 */

public class BinaryDecimal {
	
    public int binaryToDecimal(int binary){
         
        int decimal = 0;
        int power = 0;
        while(true){
            if(binary == 0){
                break;
            } else {
                int tmp = binary%10;
                decimal += tmp*Math.pow(2, power);
                binary = binary/10;
                power++;
            }
        }
        return decimal;
    }
    
    static int binaryToDecimal2(int n) 
    { 
        int dec_value = 0; 
  
        // Initializing base 
        // value to 1, i.e 2^0 
        int base = 1; 
  
        while (n > 0) { 
            int last_digit = n % 10; 
            n = n / 10; 
  
            dec_value += last_digit * base; 
  
            base = base * 2; 
        } 
        return dec_value; 
    } 
    
    public static int hexToDecimal1(String hex){
    	String digits = "0123456789ABCDEF";  //Just to know that index of A is 10, B is 11 etc.
    	hex = hex.toUpperCase(); 
        int decimal = 0;
        int power = 0;
        
        for (int i = hex.length()-1; i >= 0; i--)  
        {  
            char c = hex.charAt(i);  
            int d = digits.indexOf(c);  
            
            decimal += d*Math.pow(16, power);
            power++;
        } 
        return decimal;
    }
    
    //121=1*256+2*16+1*1=289
    
    //121->
    //16*0+1=1
    //16*1+2=18
    //16*18+1=289
    //This is different approach, if not understood, use hexToDecimal1
    public static int hexToDecimal2(String hex){  
    	 String digits = "0123456789ABCDEF";  //Just to know that index of A is 10, B is 11 etc.
         hex = hex.toUpperCase();  
         int val = 0;  
         for (int i = 0; i < hex.length(); i++)  
         {  
             char c = hex.charAt(i);  
             int d = digits.indexOf(c);  
             val = 16*val + d;  
         }  
         return val;  
    }  

     //Iterative
    public void decimalToBinary(int num){
        int binary[] = new int[40];
        int index = 0;
        while(num > 0){
          binary[index++] = num%2;
          num = num/2;
        }
        for(int i = index-1;i >= 0;i--){
          System.out.print(binary[i]);
        }
    }
    
    //Use Array technique as its expensive computationally
    public static int decimalToOctal(int decimal)
    {
        int octalNumber = 0, i = 1;

        while (decimal != 0)
        {
            octalNumber += (decimal % 8) * i;
            decimal /= 8;
            i *= 10;
        }
        return octalNumber;
    }
    
    //Use Array technique as its expensive computationally
    public static int decimalToAnyBase(int decimal, int base)
    {
        int baseNumber = 0, i = 1;

        while (decimal != 0)
        {
        	baseNumber += (decimal % base) * i;
            decimal /= base;
            i *= 10;
        }
        return baseNumber;
    }
    //Print recursive
    public void decimalToBinary2(int num){
    	if(num !=0) {
    		int bit = num%2;
            num = num/2;
            decimalToBinary2(num);
    		System.out.print(bit);
    	}
    	return;
    }
    
    static int idx=-1;
    //Array recursive, array is passed
    public void decimalToBinary3(int num, int[] binary){
    	if(num !=0) {
    		int bit = num%2;
            num = num/2;
            decimalToBinary3(num, binary);
    		binary[++idx]=(bit);
    	}
    	return;
    }
    
    static int binary2[] = new int[40];
    static int idx2=-1;
    //Recursive, array set as instance variable
    public void decimalToBinary4(int num){
    	if(num !=0) {
    		int bit = num%2;
            num = num/2;
            decimalToBinary4(num);
    		binary2[++idx2]=(bit);
    	}
    	return;
    }
    
    public void decimalToBinary5(int num){
        // Create Stack object
        Stack<Integer> stack = new Stack<>();
     
        // User input 
        while (num != 0)
        {
          int d = num % 2;
          stack.push(d);
          num /= 2;
        } 
     
        System.out.print("\nBinary representation is:");
        while (!(stack.isEmpty() ))
        {
          System.out.print(stack.pop());
        }
        System.out.println();
    }
    
    static void decToHexa(int n) 
    {    
        // char array to store hexadecimal number 
        char[] hexaDeciNum = new char[100]; 
       
        // counter for hexadecimal number array 
        int i = 0; 
        System.out.print("Hexa Decimal value of "+n+" is:"); 
        while(n!=0) 
        {    
            // storing remainder in temp variable. 
            int temp = n % 16; 
           
            // check if temp < 10 
            if(temp < 10) 
            { 
                hexaDeciNum[i] = (char)(temp + 48); 
            } 
            else
            { 
                hexaDeciNum[i] = (char)(temp + 55); 
            } 
            i++; 
            
            n = n/16; 
        } 
       
        // printing hexadecimal number array in reverse order 
        for(int j=i-1; j>=0; j--) {
            System.out.print(hexaDeciNum[j]);
        }
        System.out.println();
    } 
    
    static String idToShortURL(int n)  
    {  
        // Map to store 62 possible characters  
        char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();  
      
        StringBuffer shorturl = new StringBuffer();  
      
        // Convert given integer id to a base 62 number  
        while (n > 0)  
        {  
            // use above map to store actual character  
            // in short url  
            shorturl.append(map[n % 62]); 
            n = n / 62;  
        }  
      
        // Reverse shortURL to complete base conversion  
        return shorturl.reverse().toString();  
    }  

    // Function to get integer ID back from a short url
    static int shortURLtoID(String shortURL)  
    {  
        int id = 0; // initialize result  
      
        // A simple base conversion logic  
        for (int i = 0; i < shortURL.length(); i++)  
        {  
            if ('a' <= shortURL.charAt(i) &&  shortURL.charAt(i) <= 'z') { 
            	id = id * 62 + shortURL.charAt(i) - 'a';  //because index of a is 0(97-97)
            	//and b is 1(98-97)
            	//In hexadecimal, for A, we consider 11, B as 12
            }
            
            if ('A' <= shortURL.charAt(i) &&  shortURL.charAt(i) <= 'Z')  {
            	id = id * 62 + shortURL.charAt(i) - 'A' + 26;  //Because first a-z then A-Z then 0-9 is stored in ch. array
            	//because index of A is (65-65+26)=26
            	//because index of B is (66-65+26)=27
            }
            
            if ('0' <= shortURL.charAt(i) &&  shortURL.charAt(i) <= '9')  {
            	id = id * 62 + shortURL.charAt(i) - '0' + 52;
            	//because index of 0 is (48-48+52)=52
            	//because index of B is (49-48+52)=53
            }
        }  
        return id;  
    }  

    public static void main(String a[]){
        BinaryDecimal bd = new BinaryDecimal();
        System.out.println("110 ===> "+bd.binaryToDecimal(110));
        System.out.println("110 ===> "+bd.binaryToDecimal2(110));
        System.out.println("100110 ===> "+bd.binaryToDecimal(100110));
        
        bd.decimalToBinary(89);
        
        System.out.println(); 
        bd.decimalToBinary2(89);
        
        System.out.println(); 
        int binary1[] = new int[40];
        bd.decimalToBinary3(89, binary1);
        
		for(int i = 0;i <= idx;i++){
		   System.out.print(binary1[i]); 
		}
		
		System.out.println(); 
        bd.decimalToBinary4(89);
        
		for(int i = 0;i <= idx2;i++){
		   System.out.print(binary2[i]); 
		}
		
		bd.decimalToBinary5(89);
		
		int num=89;
		int n=bd.decimalToAnyBase(num,2);
		System.out.println("Binary of "+num+" is:"+n);
		
		num=289;
		decToHexa(num);
		String hex="121";
		System.out.println("Decimal value of hexadecimal "+hex+" is:"+hexToDecimal1(hex));
		System.out.println("Decimal value of hexadecimal "+hex+" is:"+hexToDecimal2(hex));
		
    }
}