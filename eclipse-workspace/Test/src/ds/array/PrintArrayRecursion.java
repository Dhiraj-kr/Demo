package ds.array;
/*
{1,2,4}{1} {2} {4} {1,2} {2,4} {1,2,4}

{1,2,3,4}{1} {2} {3} {4} {1,2} {2,3} {3,4} {1,2,3} {2,3,4} {1,2,3,4}

{1,2,3,4,5}{1} {2} {3} {4} {5} {1,2} {2,3} {3,4} {4,5} {1,2,3} {2,3,4} {3,4,5} {1,2,3,4} {2,3,4,5}
		{1,2,3,4,5}
		*/

class PrintArrayRecursion{

public static void main(String arg[]){
	int[] arr={1,2,4};
	subArr(arr,arr.length);
}

private static void subArr(int arr[], int length){
	if(length==0){
		return;
	}
	subArr(arr,length-1);
	System.out.println("{"+arr[length-1]+"}");
}
}