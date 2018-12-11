package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

	Node root;

	
	public Tree(int key) {
		root = new Node(key);
	}
	

	public int printPostorder(Node node) {
		int size=1;	
		if (node == null) 
	            return 1; 
	  
	        // first recur on left subtree 
	        if(node.children[0]!=null) {
	        	size++;
	        	printPostorder(node.children[0]); 
	        
	        }
	        // then recur on right subtree 
	        if(node.children[1]!=null) {
	        	size++;
	        	printPostorder(node.children[1]); 
	        }else {
	        // now deal with the node  
	        size++;
	        }
	        return size;
	}
	
	void printLevel(Tree n) {
		if(n==null) {
			System.out.println("Tree is null");
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(n.root);
		while(!q.isEmpty()) {
			Node current=q.poll();
			System.out.print(current.key);
			if(current.children[0]!=null) q.add(current.children[0]);
			if(current.children[1]!=null) q.add(current.children[1]);
		}
	}
	void printPreorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        /* first print data of node */
        System.out.print(node.key + " "); 
  
        /* then recur on left sutree */
        printPreorder(node.children[0]); 
  
        /* now recur on right subtree */
        printPreorder(node.children[1]); 
    } 
	

	int getHeight(Node root) {

		if(root==null) return 0;
		else {
	
			int leftDepth = getHeight(root.children[0]);
			int rightDepth = getHeight(root.children[1]);
			
			if(leftDepth> rightDepth)
				return(leftDepth+1);
			else return(rightDepth+1);
		}
	}
	
	
	//boolean checkIfBinaryST(Node root) {
		//int[] treeArray=new int[root.]
	//}
	
	
	//come back to this
	int checkHeight(Node root) {
		if(root==null) return -1;
		
		System.out.println("Root= "+root.key);
		//Iterates through the tree completely until it reaches last left node
		int leftHeight = checkHeight(root.children[0]);
		System.out.println(("Check height"+ checkHeight(root.children[0])));
		System.out.println("leftheight = "+ leftHeight+ "Root is :"+ root.key);
		if(leftHeight== Integer.MIN_VALUE) return Integer.MIN_VALUE;
		

		int rightHeight = checkHeight(root.children[1]);
		System.out.println("rightheight = "+ rightHeight+ "Root is :"+ root.key);
		if(rightHeight== Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int diff=leftHeight-rightHeight;
		
		if(Math.abs(diff)>1) {
			return Integer.MIN_VALUE;//error
		}else {
			return Math.max(leftHeight, rightHeight);
		}
		
		
	}
	
	boolean isBalanced(Node root) {
		return checkHeight(root)!=Integer.MIN_VALUE;
	}
	
}

