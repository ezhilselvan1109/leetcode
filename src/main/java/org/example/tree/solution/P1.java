package org.example.tree.solution;

import java.util.Stack;

class InvertTree {
    public TreeNode breadthFirstSearch(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return root;
    }

    public TreeNode depthFirstSearch(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        depthFirstSearch(root.left);
        depthFirstSearch(root.right);

        return root;
    }

    public TreeNode iterativeDFS(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return root;
    }
}
public class P1 {
    public static void main(String[] args) {
        // Tree structure:
        //        1
        //      /   \
        //     2     3
        //    / \   / \
        //   4  5  6  7

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        InvertTree solution = new InvertTree();

        System.out.println("Before Inversion:");
        TreeNode.printLevelOrder(root);

        solution.depthFirstSearch(root);
        //solution.breadthFirstSearch(root);
        //solution.iterativeDFS(root);

        System.out.println("\nAfter Inversion:");
        TreeNode.printLevelOrder(root);
    }
}