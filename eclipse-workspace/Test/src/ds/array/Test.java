a {1,2,4}{1} {2} {4} {1,2} {2,4} {1,2,4}

{1,2,3,4}{1} {2} {3} {4} {1,2} {2,3} {3,4} {1,2,3} {2,3,4} {1,2,3,4}

{1,2,3,4,5}{1} {2} {3} {4} {5} {1,2} {2,3} {3,4} {4,5} {1,2,3} {2,3,4} {3,4,5} {1,2,3,4} {2,3,4,5}
		{1,2,3,4,5}

class Test{

public static void main(String arg[]){
	Arr={1,2,4};
	subArr(arr);
}

private arr subArr(int arr[]){
	if(arr.length==0){
		return;
	}
	System.out.println("{"+arr[0]+"}");
	subArr(arr,length-1);
}
}