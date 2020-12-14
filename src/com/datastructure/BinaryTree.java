package com.datastructure;

public class BinaryTree {
    TreeNode root;

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        TreeNode(int value) {
            this.value = value;
        }
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    TreeNode addRecursive(TreeNode current, int value) {
        if (current == null)
            return new TreeNode(value);

        if (value < current.value)
            current.left = addRecursive(current.left, value);
        else if (value > current.value)
            current.right = addRecursive(current.right, value);
        else
            return current;

        return current;
    }

    void inOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        inOrderTraversal(root.right);
    }

    void preOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(root.value + " ");
    }

    void postOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.value + " ");
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
    }

}
