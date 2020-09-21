package ds;

public class LinkedList {
	
	static Node head;
	
	static class Node{
		int val;
		Node next;
		
		Node(int val){
			this.val=val;
			next=null;
		}
	}
	
	public static void main(String arg[]) {
		
		Node node1=new Node(5);
		Node node2=new Node(7);
		Node node3=new Node(9);
		Node node4=new Node(3);
		Node node5=new Node(1);
		Node node6=new Node(4);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		//node5.next=null;
		node5.next=node6;
		node6.next=null;
		
		head=node1;
		
		System.out.println("Middle Node:"+getMiddle());
		getMiddle2();
		
		display();
		reverse();
		display();
		
		Node first=head;
		Node second=first.next;
		
		first.next=null;
		reverse2(first,second);
		display();

		System.out.println("\nCount of nodes:"+getCountRec(head));
		
		System.out.println("\n3rd Node:"+getNth(head,3));
		
		/*
		 * node1=new Node(1); node2=new Node(2); node3=new Node(3); node4=new Node(4);
		 * node5=new Node(5); node6=new Node(6); Node node7=new Node(7); Node node8=new
		 * Node(8); Node node9=new Node(9); Node node10=new Node(10);
		 * 
		 * node1.next=node2; node2.next=node3; node3.next=node4; node4.next=node5;
		 */
		
		System.out.println("List is cyclic:"+isCyclic());
	}
	
	//1->2->3->4->5
	//1->2->3->4->5->6
	static int getMiddle()
	{
	      Node n=head;
	      Node d=head.next;
	      for(;n.next!=null;){
	          
	          
	          if(d==null){//For odd list
	              return n.val;
	          }
	          else if(d.next==null){//For even list
	              return n.next.val;
	          }
	          n=n.next;
	          d=d.next.next;
	      }
	      return -1;
	}
	
	static void getMiddle2()
	{
	      Node n=head;
	      Node d=head;
	      
	      int length = 0;
	      
	      for(;n.next!=null;){
	    	  
	    	  length++;
	          if(length%2 ==0){
	              d = d.next;
	          }
	          n = n.next;
	      }
	      if(length%2 == 1){
	          d = d.next;
	      }
	      
	      System.out.println("length of LinkedList: " + length);
	      System.out.println("middle element of LinkedList : " + d.val);
	      
	}

	/*
	 Two pointers, fast and slow is used while iterating over linked list. 
	 Fast pointer moves two nodes in each iteration, while slow pointer moves to one node. 
	 If linked list contains loop or cycle then 
	 both fast and slow pointer will meet at some point during iteration. 
	 If they don't meet and fast or slow will point to null, 
	 then linked list is not cyclic and it doesn't contain any loop. 
	 */
	
	//Other method is by using a visited flag
	public static boolean isCyclic(){ 

		Node fast = head; 
		Node slow = head; 

		while(fast != null && fast.next  !=  null){ 	//fast is neither last nor second last

			fast = fast.next.next; 			//access second 
			slow = slow.next; 				//access first
			//if fast and slow pointers are meeting then LinkedList is cyclic 
			if(fast == slow ){ 
				return true; 
			} 
		} 
		return false; 
	}
	
	public static void reverse(){ 
		
		Node first=head;	
		Node second=head.next;	
		
		first.next=null;
		//Once list gets reversed, it would become last element so it should point to null
		//else list will become circular
		
		while(second != null) {
			
			Node temp=second.next;//store second.next as it will be overwritten in next line
								  //set it later in second variable for next iteration
			second.next=first;
			
			first=second;		//can not use next as its pointing to reverse now so setting it to second 
			second=temp;
		}
		head=first;
	}
	
	
	public static void reverse2(Node first, Node second){ 
		if(second != null) {
			Node temp=first;
			first=second;
			reverse2(first,second.next);
			second.next=temp;
		}
		else {
			head=first;
		}
		
	}
	public static void display(){ 
		
		Node temp=head;
		System.out.println();
		while(temp != null) {
			System.out.print(temp.val+"->");
			temp=temp.next;
		}
	}
	
	public static int getCountRec(Node node) 
    { 
        // Base case 
        if (node == null) 
            return 0; 
  
        // Count is this node plus rest of the list 
        return 1 + getCountRec(node.next); 
    } 


	static int getNth(Node head, int n)  
	{  
	    if(head==null) //edge case - if head is null 
	        return -1; 
	    //if count equal to n return node.data  
	    if(n == 1)  
	    	return head.val;  
	      
	    //recursively decrease n and increase  
	    // head to next pointer  
	    return getNth(head.next, n - 1);  
	}  

}