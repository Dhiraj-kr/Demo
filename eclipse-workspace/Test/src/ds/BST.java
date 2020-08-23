package ds;
/*What is BST
Binary Search Tree is a node-based binary tree data structure which has the following properties:

The left subtree of a node contains only nodes with keys lesser than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
The left and right subtree each must also be a binary search tree.

THese are ordered or sorted binary trees.

Binary search trees keep their keys in sorted order, so that lookup and other operations can use the principle of binary search: when looking for a key in a tree (or a place to insert a new key), they traverse the tree from root to leaf, making comparisons to keys stored in the nodes of the tree and deciding, on the basis of the comparison, to continue searching in the left or right subtrees. On average, this means that each comparison allows the operations to skip about half of the tree, so that each lookup, insertion or deletion takes time proportional to the logarithm of the number of items stored in the tree. This is much better than the linear time required to find items by key in an (unsorted) array, but slower than the corresponding operations on hash tables.

*/
class Node {
	 public int data;
	 public Node left;
	 public Node right;
}

public class BST {

	static Node start;

	 public static void main(String[] args) {
		  add(10);
		  add(7);
		  add(12);
		  add(1);
		  add(6);
		
		  display(start);
	 }

	 private static void add(int i) {
		  // Create new node
		  Node p = new Node();
		  p.data = i;
		  if (start == null) {
		   start = p;
		  } else {
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
}