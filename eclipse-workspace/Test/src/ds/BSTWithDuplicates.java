package ds;



// Java program to implement basic operations  
// (search, insert and delete) on a BST that 
// handles duplicates by storing count with  
// every Node 
public class BSTWithDuplicates 
{ 
	static class Node 
	{ 
	    int key; 
	    int count; 
	    Node left, right; 
	}; 
	
	public static void main(String[] args) 
	{ 
	    /* Let us create following BST 
	            12(3) 
	        /     \ 
	    10(2)     20(1) 
	    / \ 
	    9(1) 11(1) */
	    Node root = null; 
	    root = insert(root, 12); 
	    root = insert(root, 10); 
	    root = insert(root, 20); 
	    root = insert(root, 9); 
	    root = insert(root, 11); 
	    root = insert(root, 10); 
	    root = insert(root, 12); 
	    root = insert(root, 12); 
	  
	    System.out.print("Inorder traversal of " +  
	                     "the given tree " + "\n"); 
	    inorder(root); 
	  
	    System.out.print("\nDelete 20\n"); 
	    root = deleteNode(root, 20); 
	    System.out.print("Inorder traversal of " +  
	                     "the modified tree \n"); 
	    inorder(root); 
	  
	    System.out.print("\nDelete 12\n"); 
	    root = deleteNode(root, 12); 
	    System.out.print("Inorder traversal of " +  
	                     "the modified tree \n"); 
	    inorder(root); 
	  
	    System.out.print("\nDelete 9\n"); 
	    root = deleteNode(root, 9); 
	    System.out.print("Inorder traversal of " +  
	                     "the modified tree \n"); 
	    inorder(root); 
	} 

	  
	// A utility function to create a new BST Node 
	static Node newNode(int item) 
	{ 
	    Node temp = new Node(); 
	    temp.key = item; 
	    temp.left = temp.right = null; 
	    temp.count = 1; 
	    return temp; 
	} 
	  
	// A utility function to do inorder traversal of BST 
	static void inorder(Node root) 
	{ 
	    if (root != null) 
	    { 
	        inorder(root.left); 
	        System.out.print(root.key + "(" +  
	                         root.count + ") "); 
	        inorder(root.right); 
	    } 
	} 
	  
	/* A utility function to insert a new  
	Node with given key in BST */
	static Node insert(Node Node, int key) 
	{ 
	    /* If the tree is empty, return a new Node */
	    if (Node == null) return newNode(key); 
	  
	    // If key already exists in BST,  
	    // increment count and return 
	    if (key == Node.key) 
	    { 
	    	(Node.count)++; 
	        return Node; 
	    } 
	  
	    /* Otherwise, recur down the tree */
	    if (key < Node.key) 
	        Node.left = insert(Node.left, key); 
	    else
	        Node.right = insert(Node.right, key); 
	  
	    /* return the (unchanged) Node pointer */
	    return Node; 
	} 
	  
	/* Given a non-empty binary search tree, return  
	the Node with minimum key value found in that  
	tree. Note that the entire tree does not need 
	to be searched. */
	static Node minValueNode(Node Node) 
	{ 
	    Node current = Node; 
	  
	    /* loop down to find the leftmost leaf */
	    while (current.left != null) 
	        current = current.left; 
	  
	    return current; 
	} 
	  
	/* Given a binary search tree and a key,  
	this function deletes a given key and  
	returns root of modified tree */
	static Node deleteNode(Node root, int key) 
	{ 
	    // base case 
	    if (root == null) return root; 
	  
	    // If the key to be deleted is smaller than the 
	    // root's key, then it lies in left subtree 
	    if (key < root.key) 
	        root.left = deleteNode(root.left, key); 
	  
	    // If the key to be deleted is greater than  
	    // the root's key, then it lies in right subtree 
	    else if (key > root.key) 
	        root.right = deleteNode(root.right, key); 
	  
	    // if key is same as root's key 
	    else
	    { 
	        // If key is present more than once,  
	        // simply decrement count and return 
	        if (root.count > 1) 
	        { 
	            (root.count)--; 
	            return root; 
	        } 
	  
	        // ElSE, delete the Node 
	  
	        // Node with only one child or no child 
	        if (root.left == null) 
	        { 
	            Node temp = root.right; 
	            root=null; 
	            return temp; 
	        } 
	        else if (root.right == null) 
	        { 
	            Node temp = root.left; 
	            root = null; 
	            return temp; 
	        } 
	  
	        // Node with two children: Get the inorder  
	        // successor (smallest in the right subtree) 
	        Node temp = minValueNode(root.right); 
	  
	        // Copy the inorder successor's  
	        // content to this Node 
	        root.key = temp.key; 
	  
	        // Delete the inorder successor 
	        root.right = deleteNode(root.right, 
	                                temp.key); 
	    } 
	    return root; 
	} 
	  
	} 

