package leetcode.java.general;


/*
https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 */

import java.util.*;
import java.util.stream.Collectors;

public class SymmetricTree {


    public static boolean isSymmetric(TreeNode root) {
        // bfs

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        if(compareNodes(root.left, root.right)) return true;

        return  false;

    }

    private static boolean compareNodes(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null && right != null || left != null && right == null) return false;
        if(left.val == right.val && compareNodes(left.left, right.right) && compareNodes(left.right, right.left)) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode leftleft = new TreeNode(3);
        TreeNode leftright = new TreeNode(4);

        TreeNode right = new TreeNode(2);
        TreeNode rightleft = new TreeNode(4);
        TreeNode rightright = new TreeNode(3);

        root.left = left;
        root.right = right;
        left.left = leftleft;
        left.right = leftright;

        right.left = rightleft;
        right.right = rightright;

        var output = isSymmetric(root);
        System.out.println("the output is " + output);

    }
}
