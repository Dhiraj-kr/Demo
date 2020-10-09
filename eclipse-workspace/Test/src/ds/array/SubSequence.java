package ds.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SubSequence {

	public static void main(String[] args) {
		
		int arr[]= {1,2,3,4,5};
		
		SubSequence subSeq=new SubSequence();
		List<List<Integer>> lstList=subSeq.findSubArr(arr);
		
		printList(lstList);
		//Final Output will be
		//{1},{12},{123},{1234},{12345},{2},{23},{234},{2345},{3},{34},{345},{4},{45},{5},
		
	}
	
	private List<List<Integer>> findSubArr(int[] arr) {
		
		//This list will hold all the sub lists
		List<List<Integer>> lstList=new ArrayList<>();
		
		for(int i=0;i<arr.length;i++) {
			
			//Creating new list and adding one element which is ith element
			//For i=1, it will have {1} and for i=2, it will have {2}
			List<Integer> newLst=new ArrayList<>();
			newLst.add(arr[i]);
			lstList.add(newLst);
			
			//Iterating from i+1 to end of array
			for(int j=i+1;j<arr.length;j++) {
				
				//Creating new list based on above one element list
				newLst=new ArrayList<>(newLst);
				newLst.add(arr[j]);
				lstList.add(newLst);
			}
			//for i=1, at the end of this j loop, lstList will have {1},{1,2},{123},{1234},{12345}
		}
		return lstList;
	}
	
	private static void printList(List<List<Integer>> lstList) {
		
		if(!lstList.isEmpty()) {
			Iterator<List<Integer>> it=lstList.iterator();
			
			while(it.hasNext()) {
				
				List<Integer> list=it.next();
				Iterator<Integer> it2=list.iterator();
				System.out.print("{");
				
				while(it2.hasNext()) {
					System.out.print(it2.next());
				}
				System.out.print("},");
			}
		}		
	}
}
