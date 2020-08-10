package practice;

public class MaxMinDiff {

	/*
	 * 
	 * Maximum difference between two elements such that larger element appears after the smaller number
Given an array arr[] of integers, find out the maximum difference between any two elements such that larger element appears after the smaller number.
Examples :
Input : arr = {2, 3, 10, 6, 4, 8, 1}
Output : 8
Explanation : The maximum difference is between 10 and 2.

Input : arr = {7, 9, 1, 6, 3, 5}
Output : 4
Explanation : The maximum difference is between 5 and 1.

3,10,1,9,6
Output= 9-1=8

	 */
	public static void main(String[] args) {
		
		MaxMinDiff maxMinDiff=new MaxMinDiff();
		int arr[]= {3,10,1,9,6};
		int diff = maxMinDiff.findMaxMinDiff(arr);
		System.out.println(diff);
	}
	
	private int findMaxMinDiff(int arr[]) {
		
		int maxDiff=-1;
		
		for(int i=0;i<arr.length;i++) {
			
			int e=arr[i];
			
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]>e && (arr[j]-e)>maxDiff) {
					maxDiff=arr[j]-e;
				}
			}
		}
		
		return maxDiff;
		
	}
	 

}
