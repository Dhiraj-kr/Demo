package ds.number;

public class StringToNumber {
 
    public static int convert_String_To_Number(String numStr) throws Exception{
         
        char ch[] = numStr.toCharArray();
        int sum = 0;
        //get ascii value for zero
        int zeroAscii = (int)'0';
        for(char c:ch){
            int tmpAscii = (int)c;
            if(tmpAscii>=48 && tmpAscii<=57) {
            	sum = (sum*10)+(tmpAscii-zeroAscii);
            }
            else {
            	throw new Exception();//Declare User defined exception
            }
        }
        return sum;
    }
    public static void stringToNumber() throws Exception{
	    String s="67895";
		char[] charArr=s.toCharArray();
		
		int factor=0;
		int num=0;
		
		for(int i=charArr.length-1;i>=0;i--) {
			num += (charArr[i]-48)*Math.pow(10,factor);
			factor++;
		}
		System.out.println(num);
    }
	
     
    public static void main(String a[]) throws Exception{
         
        System.out.println("\"3256\" == "+convert_String_To_Number("3256"));
        System.out.println("\"76289\" == "+convert_String_To_Number("76289"));
        System.out.println("\"90087\" == "+convert_String_To_Number("90087"));
    }
}