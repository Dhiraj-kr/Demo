package number;
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
		ng.findNextGreater33(arr);
		System.out.println("--------");
		int arr1[]= {13, 7, 6, 12};
		ng.findNextGreater33(arr1);
		System.out.println("--------");
		int arr11[]= {13, 7, 6, 26};
		ng.findNextGreater33(arr11);
		System.out.println("--------");
		int arr2[]= {13, 12, 11, 10};
		ng.findNextGreater33(arr2);
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
	//13,7,6,12    s->13, s->7,13
	//4,5,2,25
	private void findNextGreater33(int arr[]) {
		
		Stack s=new Stack();
		int e=-1;
		for(int i=1;i<arr.length;i++) {
			
			if(arr[i]>arr[i-1]) {
				
				while(!s.isEmpty()) {
					e=s.pop();
					if(arr[i] > e )
						System.out.println("Next greater for "+ e +" is: "+arr[i]);
					else {
						System.out.println("Next greater for "+ e +" is: -1");
					}
				}
				System.out.println("Next greater for "+ arr[i-1] +" is: "+arr[i]);
				
			}
			else {
				s.push(arr[i-1]);
			}
			
		}
		while(!s.isEmpty()) {
			e=s.pop();
			System.out.println("Next greater for "+ e +" is: -1");
		}
		System.out.println("Next greater for "+ arr[arr.length-1] +" is: -1");
	}
	
	/*
	 
	 Method 2 (Using Stack)

Push the first element to stack.
Pick rest of the elements one by one and follow the following steps in loop.
Mark the current element as next.
If stack is not empty, compare top element of stack with next.
If next is greater than the top element,Pop element from stack. next is the next greater element for the popped element.
Keep popping from the stack while the popped element is smaller than next. next becomes the next greater element for all such popped elements
Finally, push the next in the stack.
After the loop in step 2 is over, pop all the elements from stack and print -1 as next element for them.
	*/ 
	//4,5,2,25
	private void findNextGreater3(int arr[]) {
		
		Stack s=new Stack();
		s.push(arr[0]);
		int e=-1;
		for(int i=1;i<arr.length;i++) {
			int next=arr[i];
			
			if(!s.isEmpty()) {
				e=s.pop();
				while(next > e) {
					System.out.println("Next greater for "+ e +" is: "+next);
					if(s.isEmpty()) {
						break;
					}
					e=s.pop();
				}
				if(e > next) {
					s.push(e);
				}
			}
			s.push(next);
			
		}
		while((e=s.pop())!=-1) {
			System.out.println("Next greater for "+ e +" is: -1");
		}
	}
	
	
	static class Stack{
		int arr[]=new int[100];
		int top=-1;
		
		public int pop() {
			if(top==-1) {
				return -1;
			}
			else {
				return arr[top--];
			}
		}
		
		public void push(int e) {
			if(top==99) {
				System.out.println("Stack Full");
			}
			else {
				arr[++top]=e;
			}
		}
		public boolean isEmpty() {
			if(top==-1) {
				return true;
			}
			else {
				return false;
			}
		}
	}

}
