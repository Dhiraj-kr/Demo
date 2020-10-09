package ds.array;

//Java program to find union(merge) of two sorted arrays 
//Can be done using merge sort also

class FindUnion { 
	
	public static void main(String args[]) 
	{ 
		int arr1[] = { 1, 2, 4, 5, 6 }; 
		int arr2[] = { 2, 3, 5, 7 }; 
		int m = arr1.length; 
		int n = arr2.length; 
		
		System.out.println("Union:");
		printUnion(arr1, arr2, m, n); 
		
		System.out.println("\nIntersection:");
		printIntersection(arr1, arr2, m, n); 
		
		int arr3[] = { 1, 2, 2, 2, 3 }; 
        int arr4[] = { 2, 3, 4, 5 }; 
        System.out.println("\nUnion(Handling duplicates):");
        unionArray(arr3, arr4); 
	} 
	
	/* Function prints union of arr1[] and arr2[] 
	m is the number of elements in arr1[] 
	n is the number of elements in arr2[] */
	static int printUnion(int arr1[], int arr2[], int m, int n) 
	{ 
		int i = 0, j = 0; 
		while (i < m && j < n) { 
			if (arr1[i] < arr2[j]) 
				System.out.print(arr1[i++] + " "); 
			else if (arr2[j] < arr1[i]) 
				System.out.print(arr2[j++] + " "); 
			else if(arr2[j] == arr1[i]){ 
				System.out.print(arr2[j++] + " "); //or print arr[i++] then j++
				i++; 
			} 
		} 

		/* Print remaining elements of 
		the larger array */
		while (i < m) 
			System.out.print(arr1[i++] + " "); 
		while (j < n) 
			System.out.print(arr2[j++] + " "); 

		return 0; 
	} 
	
	/* Function prints Intersection of arr1[] and arr2[] 
    m is the number of elements in arr1[] 
    n is the number of elements in arr2[] */
	 static void printIntersection(int arr1[], int arr2[], int m, int n) 
	 { 
	     int i = 0, j = 0; 
	     while (i < m && j < n) { 
	         if (arr1[i] < arr2[j]) 
	             i++; 		//No print
	         else if (arr2[j] < arr1[i]) 
	             j++; 		//No print
	         else { 
	             System.out.print(arr2[j++] + " "); //or print arr[i++] then j++
	             i++; 
	         } 
	     } 
	 } 
	
	static void unionArray(int arr1[], int arr2[]) { 
		// Taking max element present in either array 
		
		int m = max(arr1);	 
		int n = max(arr2);  
		
		int ans = 0; 
		
		if (m > n) { 
			ans = m; 
		} 
		else
			ans = n; 
		
		// Using another array for storing union elements of both arrays. 
		// Assuming max element present in array is not more than 10^7 
		int newtable[] = new int[ans + 1]; 
		
		// First element is always 
		// present in final answer 
		System.out.print(arr1[0] + " "); 
		
		// Incrementing the First element's count 
		// in it's corresponding index in newtable 
		++newtable[arr1[0]]; 
		
		// Starting traversing the first 
		// array from 1st index till last 
		for (int i = 1; i < arr1.length; i++) { 
			// Checking whether current element 
			// is not equal to it's previous element 
			if (arr1[i] != arr1[i - 1]) { 
				 System.out.print(arr1[i] + " "); 
				 ++newtable[arr1[i]]; 
			}	 
		} 

		// Finding only non common elements from 2nd array 
		for (int j = 0; j < arr2.length; j++) { 
			// By checking whether it's already 
			// present in newtable or not 
			if (newtable[arr2[j]] == 0) { 
				 System.out.print(arr2[j] + " "); 
				 ++newtable[arr2[j]]; 
			} 
		} 
	} 
	
	static int max(int arr[]) {
		int max=-1;
		for(int a:arr) {
			if(a>max) {
				max=a;
			}
		}
		return max;
	}
} 
