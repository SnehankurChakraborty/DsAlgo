package com.dsalgo.datastructure.tree;

import com.dsalgo.algorithms.BinarySearch;
import com.dsalgo.datastructure.queues.Queue;

public class BinarySearchTree<T> {

    private TreeNode rootNode;

    private class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public BinarySearchTree(int data) {
        this.rootNode = new TreeNode(data);
    }

    public TreeNode getRoot() {
        return this.rootNode;
    }

    public void insert(int data) {
        TreeNode node = findNode(this.rootNode, data);
        if (data > node.data) node.right = new TreeNode(data);
        else node.left = new TreeNode(data);
    }

    public TreeNode findNode(TreeNode node, int data) {
        if (data > node.data && null != node.right) return findNode(node.right, data);
        else if (null != node.left) return findNode(node.left, data);
        else return node;
    }

    public void iterativeLevelOrder() {
        Queue<TreeNode> queue = new Queue<>();
        TreeNode node = this.rootNode;
        queue.enqueue(node);
        while (!queue.isEmpty()) {
            node = queue.dequeue();
            System.out.print(node.data);
            if (null != node.left) queue.enqueue(node.left);
            if (null != node.right) queue.enqueue(node.right);
        }
    }

    public boolean validateBinaryTree() {
        return validateNode(this.rootNode, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean validateNode(TreeNode node, int max, int min) {
        if (null == node) return true;
        else if (node.data > max || node.data < min) return false;
        return validateNode(node.left, node.data, min) && validateNode(node.right, max, node.data);
    }
}
