package practice;
/*
 
  Next Greater Element
Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.
Examples:
1.	For any array, rightmost element always has next greater element as -1.
2.	For an array which is sorted in decreasing order, all elements have next greater element as -1.
3.	For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1
d) For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.

  Element        NGE
   13      -->    -1
   7       -->     12
   6       -->     12
   12      -->     -1

 
 */

public class NextGreater {
	
	public static void main(String arg[]) {
		NextGreater ng=new NextGreater();
		int arr[]= {4, 5, 2, 25};
		ng.findNextGreater2(arr);
		System.out.println("--------");
		int arr1[]= {13, 7, 6, 12};
		ng.findNextGreater2(arr1);
		System.out.println("--------");
		int arr11[]= {13, 7, 6, 26};
		ng.findNextGreater2(arr11);
		System.out.println("--------");
		int arr2[]= {13, 12, 11, 10};
		ng.findNextGreater2(arr2);
	}

	private void findNextGreater(int arr[]) {
		
		for(int i=0;i<arr.length;i++) {
			int greater=-1;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]>arr[i]) {
					greater=arr[j];
					break;
				}
			}
			System.out.println("Next greater for "+ arr[i] +" is: "+greater);
		}
	}
	
	
	private void findNextGreater2(int arr[]) {
		
		int printForPrev=0;
		
		for(int i=1;i<arr.length;i++) {
			
			if(arr[i]>arr[i-1]) {
				
				while(printForPrev>0) {
					if(arr[i] > arr[i-1-printForPrev] )
						System.out.println("Next greater for "+ arr[i-1-printForPrev] +" is: "+arr[i]);
					else {
						System.out.println("Next greater for "+ arr[i-1-printForPrev] +" is: -1");
					}
					printForPrev--;
				}
				System.out.println("Next greater for "+ arr[i-1] +" is: "+arr[i]);
				
			}
			else {
				printForPrev++;
			}
			
		}
		while(printForPrev>0) {
			System.out.println("Next greater for "+ arr[arr.length-1-printForPrev] +" is: -1");
			printForPrev--;
		}
		System.out.println("Next greater for "+ arr[arr.length-1] +" is: -1");
	}
	
}
