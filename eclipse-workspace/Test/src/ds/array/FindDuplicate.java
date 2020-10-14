/**
 * 
 */
package ds.array;

/**
 * @author DM
 *
 */
//Assuming there is one duplicate number but it could be repeated more than once
//
public class FindDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6,3};
		//int arr[]= {3,1,3,4,2};
		FindDuplicate  fd=new FindDuplicate();
		fd.find(arr);
	}

	/**
	 * 
	 */
	private void find(int arr[]) {
		int tortoise=arr[0];
		int hare=arr[0];
		while(true) {
			tortoise=arr[tortoise];
			hare=arr[arr[hare]];
			if(tortoise == hare) {
				break;
			}
		}
		int ptr1=arr[0];
		int ptr2=tortoise;
		while(ptr1 != ptr2) {
			ptr1=arr[ptr1];
			ptr2=arr[ptr2];
		}
		System.out.println("Duplicate is "+ptr1);
	}

}
