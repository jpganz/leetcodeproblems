package leetcode.java.general;

/*
https://leetcode.com/problems/balanced-binary-tree/description/
 */
public class BalancedBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftDepth = (root.left == null) ? 1 : 1 + depth(root.left);
        int rightDept =  (root.right == null) ? 1 : 1 + depth(root.right);;

        System.out.println(leftDepth);
        System.out.println(rightDept);
        return (Math.abs(leftDepth - rightDept) <= 1 &&
                isBalanced(root.left) && isBalanced(root.right));
    }

    private static int depth(TreeNode parent) {
        return 1 + Math.max(
                (parent.left == null) ? 0 : depth(parent.left),
                (parent.right == null) ? 0 :depth(parent.right)
        );

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