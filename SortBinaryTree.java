
public class SortBinaryTree {
		static TreeNode root;   // Pointer to the tree

	   
	   /**
	    * An TreeNode object of a tree
	    */
	   static class TreeNode {
	       double item;      // Data of the node
	       TreeNode left;    // Pointer to left subtree.
	       TreeNode right;   // Pointer to right subtree.
	       TreeNode(double x) {// constructor that makes a node containing x    
	          item = x;
	       }
	   } 


	   /**
	    * Add x to the binary sort tree to which the global variable "root" refers.
	    */
	   static void treeInsert(double x) {
	      if ( root == null ) {
	          // meaning if root is empty then first node becomes root
	          root = new TreeNode( x );
	          return;
	       }
	       TreeNode curr; // variable to traverse the tree 
	       curr = root;   // Start at the root.
	       while (true) {
	          if ( x < curr.item ) {
	        	  // if x is less than curr then move to left of root
	        	  // if there is space then add x to left subnode otherwise 
	        	  // keep traversing
	             if ( curr.left == null ) {
	                curr.left = new TreeNode( x );
	                return;  // New item has been added to the tree.
	             }
	             else
	                curr = curr.left;
	          }
	          else {
	        	// if x is greater than curr then move to right of root
	        	 // if there is space then add x to right subnode otherwise 
	        	 // keep traversing
	             if ( curr.right == null ) {
	                curr.right = new TreeNode( x );
	                return;  // New item has been added to the tree.
	             }
	             else
	                curr = curr.right;
	           }
	       } 
	   }  


	   /**
	    * Return the number of leaves in the tree to which node points.
	    */
	   static int countLeaves(TreeNode node) {
	       if (node == null)
	          return 0;
	       else if (node.left == null && node.right == null)
	          return 1;  // Node is a leaf.
	       else
	    	   // recursively return left and right node leaves
	          return countLeaves(node.left) + countLeaves(node.right);
	   } 
	   

	   /**
	    * Return sum of the depths of all the leaves in the tree to which root points 
	    */   
	   static int sumOfLeafDepths( TreeNode node, int depth ) {
	       if ( node == null ) {
	        // tree is empty no leaf
	          return 0;
	       }
	       else if ( node.left == null && node.right == null) {
	             // The node is a leaf return the sum of depths of this leaf
	          return depth;
	       }
	       else {
	           // recursively return the depth of left and right children of node
	          return sumOfLeafDepths(node.left, depth + 1) 
	                      + sumOfLeafDepths(node.right, depth + 1);
	       }
	   } 
	   
	   
	   /**
	    * Return the max of the depths of all the leaves in the tree to which root points.
	    */
	   static int maximumLeafDepth( TreeNode node, int depth ) {
	       if ( node == null ) {
	            // The tree is empty.  Return 0.
	          return 0;
	       }
	       else if ( node.left == null && node.right == null) {
	           // node is a leaf return the maximum leaf depth of this node
	          return depth;
	       }
	       else {
	    	// recursively return the maximum depth of left and right children of node
	          int leftMax = maximumLeafDepth(node.left, depth + 1);
	          int rightMax =  maximumLeafDepth(node.right, depth + 1);
	          if (leftMax > rightMax)
	             return leftMax;
	          else
	             return rightMax;
	       }
	   } 
	   

	   public static void main(String[] args) {
		   root = null;  // Start with an empty tree.  

		   // Insert 1023 random items.

		   for (int i = 0; i < 1023; i++)
			   treeInsert(Math.random()); 

		   // Get the results of computing

		   int leafCount = countLeaves(root);
		   int depthSum = sumOfLeafDepths(root,0);
		   int depthMax = maximumLeafDepth(root,0);
		   double averageDepth = ((double)depthSum) / leafCount;

		   // Printing the results

		   System.out.println("Number of leaves: " + leafCount);
		   System.out.println("Average depth of leaves: " + averageDepth);
		   System.out.println("Maximum depth of leaves: " + depthMax);
	}

}
/* Output
Number of leaves: 337
Average depth of leaves: 12.198813056379821
Maximum depth of leaves: 21
*/
