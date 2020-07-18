package convert;

public class Converter {

	public static void main(String arg[]) {
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
}
