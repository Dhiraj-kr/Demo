package ds.arrayrotate;

//Java program to rotate an array by d elements 

//Time complexity: O(d*n)
//Space: O(1)

class RotateArrayOne { 
	
	public static void main(String[] args) 
	{ 
		RotateArrayOne rotate = new RotateArrayOne(); 
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 }; 
		rotate.leftRotate(arr, 2); 
		rotate.printArray(arr); 
	} 
	
	/*Function to left rotate arr[] of size n by d*/
	void leftRotate(int arr[], int d) 
	{ 
		for (int i = 0; i < d; i++) 
			leftRotatebyOne(arr); 
	} 

	void leftRotatebyOne(int arr[]) 
	{ 
		int i, temp; 
		temp = arr[0]; 
		for (i = 0; i < arr.length - 1; i++) 
			arr[i] = arr[i + 1]; 
		arr[i] = temp; 
	} 

	/* utility function to print an array */
	void printArray(int arr[]) 
	{ 
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i] + " "); 
	} 

} 

//This code has been contributed by Mayank Jaiswal 
