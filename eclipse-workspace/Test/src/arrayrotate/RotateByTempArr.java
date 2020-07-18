package arrayrotate;

public class RotateByTempArr {

	public static void main(String[] args) {

		RotateByTempArr rotate = new RotateByTempArr(); 
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 }; 
		rotate.leftRotate(arr, 2); 
		rotate.printArray(arr); 
	}
	// Output should be- 3 4 5 6 7 1 2
	private void leftRotate(int arr[], int d) {
		
		int[] temp=new int[d];
		
		for(int i=0; i < arr.length; i++) {
			
			if(i<d) {
				temp[i]=arr[i];
			}
			else {
				arr[i-d]=arr[i];
			}
		}
		for(int j=(arr.length-d), k=0 ; j < arr.length; j++, k++) {
			arr[j]=temp[k];
		}
	}
	
	private void printArray(int arr[]) 
	{ 
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i] + " "); 
	} 
}
