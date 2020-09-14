package number;

public class TwoMaximum {

	public static void main(String []args){
		int[] nums= {3,7,5,9,2};
		int maxOne = 0;
		int maxTwo = 0;
		for(int n:nums){
            if(maxOne < n){
                maxTwo = maxOne;
                maxOne =n;
            } else if(maxTwo < n){
                maxTwo = n;
            }
		}
		System.out.println("Max One:"+maxOne+" and max two:"+maxTwo);
	}
}
