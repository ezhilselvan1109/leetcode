package org.problem.trees.solution;

import java.util.LinkedList;
import java.util.Queue;

class MaxDepth {
    public int recursiveDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(recursiveDFS(root.left), recursiveDFS(root.right));
    }

    public int breadthFirstSearch(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            level++;
        }
        return level;
    }
}

public class P2 {
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

        MaxDepth solution = new MaxDepth();

        System.out.println("Before Inversion:");
        TreeNode.printLevelOrder(root);

        solution.recursiveDFS(root);
        //solution.breadthFirstSearch(root);

        System.out.println("\nAfter Inversion:");
        TreeNode.printLevelOrder(root);
    }
}

