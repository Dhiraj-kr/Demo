package ds.arrayrotate;

public class ReversalRotate {
	// Java program for reversal algorithm of array rotation 
	
	/* Driver program to test above functions */
	//Time Complexity: O(n)
	public static void main(String[] args) 
	{ 
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 }; 
		leftRotate(arr, 2); // Rotate array by 2 
		printArray(arr); 
	} 

	/* Function to left rotate arr[] of size n by d */
	static void leftRotate(int arr[], int d) 
	{ 
		int n = arr.length; 			//1,2,3,4,5,6,7
		rvereseArray(arr, 0, d - 1); 	//2,1,----	
		rvereseArray(arr, d, n - 1); 	//--7,6,5,4,3
		rvereseArray(arr, 0, n - 1); 	//3,4,5,6,7,1,2
	} 

	/*Function to reverse arr[] from index start to end*/
	static void rvereseArray(int arr[], int start, int end) 
	{ 
		int temp; 
		while (start < end) { 
			temp = arr[start]; 
			arr[start] = arr[end]; 
			arr[end] = temp; 
			start++; 
			end--; 
		} 
	} 

	/*UTILITY FUNCTIONS*/
	/* function to print an array */
	static void printArray(int arr[]) 
	{ 
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i] + " "); 
	} 

		
} 
