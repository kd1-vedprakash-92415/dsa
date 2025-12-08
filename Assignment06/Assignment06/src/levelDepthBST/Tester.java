package levelDepthBST;

public class Tester {

	    public static void main(String[] args) {
	        TreeNode root = new TreeNode(5);
	        root.left = new TreeNode(3);
	        root.right = new TreeNode(8);
	        root.left.left = new TreeNode(2);
	        root.right.left = new TreeNode(7);
	        root.right.right = new TreeNode(9);

	        System.out.println(BSTLevel.findLevel(root, 5));  
	        System.out.println(BSTLevel.findLevel(root, 3));  
	        System.out.println(BSTLevel.findLevel(root, 7));  
	        System.out.println(BSTLevel.findLevel(root, 10)); 

	        System.out.println(BSTLevel.findLevelIterative(root, 2)); 
	    }
	}
