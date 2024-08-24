package leetcode.java.general;

/*
https://leetcode.com/problems/balanced-binary-tree/description/
 */
public class BalancedBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;
        int leftDepth = (root.left == null) ? 0 : depth(root.left);
        int rightDepth = (root.right == null) ? 0 : depth(root.right);

        return (Math.abs(leftDepth - rightDepth) < 2
                && isBalanced(root.left)
                && isBalanced(root.right)
        );
    }

    private static int depth(TreeNode parent) {
       int left = (parent.left == null) ? 0 : depth(parent.left);
       int right = (parent.right == null) ? 0 : depth(parent.right);
       return 1 + Math.max(left, right);
    }



    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left =  new TreeNode(2);
        root.right =  new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);

        boolean response = isBalanced(root);
        System.out.println("is it balanced? " + response);

    }

    private static void fillTree(int leftValue, int rightValue, TreeNode parentNode) {
        parentNode.left = new TreeNode(leftValue);
        parentNode.right = new TreeNode(rightValue);
    }
}