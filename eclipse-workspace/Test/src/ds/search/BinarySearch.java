package search;

public class BinarySearch {

	public static void main(String a[]){
		
	}
	
	public int iterativeBinarySearch(int[] inputArr, int key) {
        int start = 0;
        int end = inputArr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key == inputArr[mid]) {
                return mid;
            }
            if (key < inputArr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
	}
	
	public static int recursiveBinarySearch(int[] sortedArray, int start, int end, int key) {
        if (start < end) {
            int mid = (start + end) / 2;  
            if (key < sortedArray[mid]) {
                return recursiveBinarySearch(sortedArray, start, mid, key);
                 
            } else if (key > sortedArray[mid]) {
                return recursiveBinarySearch(sortedArray, mid+1, end , key);
            } else {
                return mid;   
            }
        }
        return -1;  
    }

}
