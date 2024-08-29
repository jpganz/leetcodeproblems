package leetcode.java.general;


/*
https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 */

import java.util.*;
import java.util.stream.Collectors;

public class InorderTransversal {

    /*
     //dfs here :) its wrong :(
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> visitedNodes = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.peek();
            visitedNodes.add(current);
            if(current.left != null && !visitedNodes.contains(current.left)) {
                queue.add(current.left);
            }
            if(current.right != null && !visitedNodes.contains(current.right)) {
                queue.add(current.right);
            }
        }

        var values = visitedNodes.stream().map(it -> it.val).collect(Collectors.toList());
        System.out.println("values here lala");
        System.out.println(values);
     */
    public static List<Integer> inorderTraversal(TreeNode root) {

        //bts here :)
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> visitedNodesStack = new ArrayList<>();

        TreeNode current = root;
        while(current != null || !stack.isEmpty()) {
            // we iterate all left side until find a null
            while(current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            visitedNodesStack.add(current);
            current = current.right;
        }

        List<Integer> stackValues = visitedNodesStack.stream().map(it -> it.val).collect(Collectors.toList());
        return stackValues;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode right1Left = new TreeNode(3);
        root.right = right1;
        right1.left = right1Left;
        System.out.println(inorderTraversal(root));

    }
}
