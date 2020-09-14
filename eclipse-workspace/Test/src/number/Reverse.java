package number;

public class Reverse {

	public static void main(String []args){
		int n=123;
		Reverse r=new Reverse();
		System.out.println("Reverse of "+n+" is:"+r.reverse(n));
	}
	
	public int reverse(int number){
        int reverse = 0;
        while(number != 0){
            reverse = (reverse*10)+(number%10);
            number = number/10;
        } 
        return reverse;
	}
}
