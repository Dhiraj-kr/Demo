package number;

public class MaxMinDiff2 {

	/*
	 * 
	 * Maximum difference between two elements such that larger element appears after the smaller number
Given an array arr[] of integers, find out the maximum difference between any two elements such that larger element appears after the smaller number.
Examples :
Input : arr = {2, 3, 10, 6, 4, 8, 1}
Output : 8
Explanation : The maximum difference is between 10 and 2.

Input : arr = {7, 9, 5, 6, 3, 2}
Output : 2
Explanation : The maximum difference is between 9 and 7.

3,10,1,9,6
Output= 9-1=8

	 */
	

	public static void main(String[] args) {
		
		MaxMinDiff2 maxMinDiff=new MaxMinDiff2();
		int arr[]= {3,10,1,9,6};
		int diff = maxMinDiff.findMaxMinDiff(arr);
		//int diff = maxMinDiff.findMaxMinDiff2(arr);
		System.out.println(diff);
	}
	
	private int findMaxMinDiff(int arr[]) {
		
		int min=arr[0];
		int maxDiff=-1;
		
		for(int i=1;i<arr.length;i++) {
			
			if(min>arr[i]) {
				min=arr[i];
			}
			if((arr[i]-min)>maxDiff) {
				maxDiff=arr[i]-min;
			}
			
		}
		
		return maxDiff;
	}
	
	private int findMaxMinDiff2(int arr[]) {
		
		int n=arr.length;
		int max=arr[n-1];
		int maxDiff=-1;
		
		for(int i=n-2;i>0;i--) {
			
			if(arr[i]>max) {
				max=arr[i];
			}
			if((max-arr[i])>maxDiff) {
				maxDiff=max-arr[i];
			}
			
		}
		
		return maxDiff;
	}
	// 2,4,10,6,4,8,1 -> 2,6,-4,-2,4,-7
	int maxDiff(int arr[], int n)  
    { 
        // Create a diff array of size n-1. The array will hold 
        //  the difference of adjacent elements 
        int diff[] = new int[n - 1]; 
        for (int i = 0; i < n - 1; i++) 
            diff[i] = arr[i + 1] - arr[i]; 
  
        // Now find the maximum sum subarray in diff array 
        int max_diff = diff[0]; 
        for (int i = 1; i < n - 1; i++)  
        { 
            if (diff[i - 1] > 0)  
                diff[i] += diff[i - 1]; 
            if (max_diff < diff[i]) 
                max_diff = diff[i]; 
        } 
        return max_diff; 
    } 
	// 2,4,10,6,4,8,1 -> 2,6,-4,-2,4,-7
	int maxDiff2(int arr[], int n)  
	{  
	    // Initialize diff, current  
	    // sum and max sum  
	    int diff = arr[1] - arr[0];  
	    int curr_sum = diff;  
	    int max_sum = curr_sum;  
	  
	    for(int i = 1; i < n - 1; i++)  
	    {  
	        // Calculate current diff  
	        diff = arr[i + 1] - arr[i];  
	  
	        // Calculate current sum  
	        if (curr_sum > 0)  
	        curr_sum += diff;  
	        else
	        curr_sum = diff;  
	  
	        // Update max sum, if needed  
	        if (curr_sum > max_sum)  
	        max_sum = curr_sum;  
	    }  
	  
	    return max_sum;  
	}  

}
