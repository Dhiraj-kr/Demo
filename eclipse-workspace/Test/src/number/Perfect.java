package number;

public class Perfect {

	/*
	 The first perfect number is 6, because 1, 2 and 3 are its proper positive divisors, 
	 and 1 + 2 + 3 = 6. 
	 Equivalently, the number 6 is equal to half the sum of all its positive divisors:
		(1 + 2 + 3 + 6) / 2 = 6.

	 */
	public static void main(String []args){
		Perfect perfect=new Perfect();
		perfect.isPerfectNumber(6);
	}
	
	public boolean isPerfectNumber(int number){
        int temp = 0;
        for(int i=1;i<=number/2;i++){
            if(number%i == 0){
                temp += i;
            }
        }
        if(temp == number){
            System.out.println("It is a perfect number");
            return true;
        } else {
            System.out.println("It is not a perfect number");
            return false;
        }
    }

}
