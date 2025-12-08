package levelDepthBST;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BSTLevel {
    

    public static int findLevel(TreeNode root, int target) {
        return findLevelHelper(root, target, 1);
    }
    
    private static int findLevelHelper(TreeNode node, int target, int level) {
        if (node == null) {
            return -1;
        }
        if (node.val == target) {
            return level;
        }
        if (target < node.val) {
            return findLevelHelper(node.left, target, level + 1);
        } else {
            return findLevelHelper(node.right, target, level + 1);
        }
    }

    public static int findLevelIterative(TreeNode root, int target) {
        TreeNode current = root;
        int level = 1;
        
        while (current != null) {
            if (current.val == target) {
                return level;
            } else if (target < current.val) {
                current = current.left;
                level++;
            } else {
                current = current.right;
                level++;
            }
        }
        return -1; 
    }
}
