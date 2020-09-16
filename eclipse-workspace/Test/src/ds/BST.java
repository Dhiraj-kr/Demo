package ds;

/*What is BST

Binary Search Tree is a node-based binary tree data structure which has the following properties:

The left subtree of a node contains only nodes with keys lesser than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
The left and right subtree each must also be a binary search tree.

These are ordered or sorted binary trees.

Binary search trees keep their keys in sorted order, so that lookup and other operations 
can use the principle of binary search: when looking for a key in a tree 
(or a place to insert a new key), they traverse the tree from root to leaf, 
making comparisons to keys stored in the nodes of the tree and 
deciding, on the basis of the comparison, to continue searching in the left or right subtrees. 
On average, this means that each comparison allows the operations to skip about half of the tree, 
so that each lookup, insertion or deletion takes time proportional to the logarithm of the number of
items stored in the tree. This is much better than the linear time required to find items by key 
in an (unsorted) array, but slower than the corresponding operations on hash tables.

*/


public class BST {
	
	static class Node {
		 public int data;
		 public Node left;
		 public Node right;
	}

	static Node start;

	public static void main(String[] args) {
		
		  add(10); 
		  add(7); 
		  add(12); 
		  add(1); 
		  add(6);

		 //This can result in incorrect BST as we are manually setting left and right. Using below
   		 //way, we can add in binary tree
		 //tree.root= new Node(1); 
		 //tree.root.left= new Node(2); 
		 //tree.root.right= new Node(3); 
		 //tree.root.left.left= new Node(4); 
		 //tree.root.left.right= new Node(5);
			
		 display(start);	//It will display inorder which will be sorted
		  
		 System.out.println("Height of tree:"+getHeight(start));
		 
		 printLevelOrder();
	 }

	 private static void add(int i) {
		  // Create new node
		  Node p = new Node();
		  p.data = i;
		  if (start == null) {
			  start = p;
		  } 
		  else {
			  placeNode(p, start);
		  }
	 }

	 private static void placeNode(Node p, Node target) {
	  
		  //Check if p.data is less than target.data
		  //If yes than check if target.left is null
		  //If yes than attach new node to target.left
		  //If no than call placeNode with target as target.left
		  if (p.data < target.data) {
			   if (target.left == null) {
				   target.left = p;
			   } else {
				   placeNode(p, target.left);
			   }
		  }
		  //If yes than check if target.right is null
		  //If yes than attach new node to target.right
		  //If no than call placeNode with target as target.right
		  if (p.data > target.data) {
			   if (target.right == null) {
				   target.right = p;
			   } else {
				   placeNode(p, target.right);
			   }
		  }
	
	 }

	 //In order
	 private static void display(Node target) {
		  //Check if the node has left node
		  if (target.left != null) {
		   //if left node is present call display with left node as target
			  display(target.left);
		  }
		  
		  //Print the data when left is null
		  System.out.println(target.data);
		  
		  if (target.right != null) {
		   //if right node is present call display with right node as target
			  display(target.right);
		  }
	 }
	 
	 //Not Clear
	 //Write iterative
	 public static int getHeight(Node root){
    	if(root == null) return -1;	//or 0
		return (1+Math.max(getHeight(root.left),getHeight(root.right)));
	}
	 
	/* Compute the "height" of a tree -- the number of 
	nodes along the longest path from the root node 
	down to the farthest leaf node.*/
	 
	 //we calculate height of each left and right tree for every node
	 //then compare and return
	static int height(Node root) 
	{ 
		if (root == null) 
			return 0; 
		else
		{ 
			/* compute height of each subtree */
			int lheight = height(root.left); 
			int rheight = height(root.right);
			
			System.out.println("To return greater of "+(lheight+1)+" or "+(rheight+1)+" for "+root.data);
			
			/* use the larger one */
			if (lheight > rheight) 
				return(lheight+1); 
			else 
				return(rheight+1); 
		} 
	} 
	
	static void printLevelOrder() 
	 { 
		int h = height(start); 
		int i; 
		for (i=1; i<=h; i++) 
			printGivenLevel(start, i); 
	} 

	/* Print nodes at the given level */
	//called from a loop
	/*
	 		10
	 	 7		12
	  1
	     6
	 */
	static void printGivenLevel (Node root ,int level) 
	{ 
		if (root == null) 
			return; 
		if (level == 1) {						//To print level 3, we go 2 levels down 
			//by 2 recursive calls for left and right by decrementing level
			System.out.println(root.data + " "); 
		}
		else if (level > 1) 
		{ 
			printGivenLevel(root.left, level-1); 
			printGivenLevel(root.right, level-1); 
		} 
	} 
	
	static void printGivenLevelIterative (Node root ,int level) 
	{ 
		 
	} 
}