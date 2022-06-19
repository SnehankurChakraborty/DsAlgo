package com.dsalgo.datastructure.tree;

import com.dsalgo.datastructure.queues.Queue;
import com.dsalgo.datastructure.stacks.Stack;
import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;

public class BinaryTree {

    private TreeNode root;

    private class TreeNode<T> {
        private TreeNode<T> left;
        private TreeNode<T> right;
        private T data;

        public TreeNode(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "{" + this.data + "}\n";
        }
    }


    public TreeNode getRoot() {
        return this.root;
    }

    public BinaryTree() {
        TreeNode<Integer> node1 = new TreeNode<>(6);
        TreeNode<Integer> node2 = new TreeNode<>(4);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(5);
        TreeNode<Integer> node5 = new TreeNode<>(1);
        TreeNode<Integer> node6 = new TreeNode<>(7);
        TreeNode<Integer> node7 = new TreeNode<>(2);
        TreeNode<Integer> node8 = new TreeNode<>(9);
        TreeNode<Integer> node9 = new TreeNode<>(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        this.root = node1;
    }

    public void iterativePreOrder(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<Integer> node = stack.pop();
            System.out.print(node.data);
            if (null != node.right) stack.push(node.right);
            if (null != node.left) stack.push(node.left);
        }
    }

    public void recursivePreOrder(TreeNode<Integer> root) {
        if (null == root) return;
        System.out.print(root.data);
        recursivePreOrder(root.left);
        recursivePreOrder(root.right);
    }

    public void recursiveInOrder(TreeNode<Integer> root) {
        if (null == root) return;
        recursiveInOrder(root.left);
        System.out.print(root.data);
        recursiveInOrder(root.right);
    }

    public void iterativeInOrder(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> temp = root;
        while (!stack.isEmpty() || null != temp) {
            if (null != temp) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data);
                temp = temp.right;
            }

        }
    }

    public void recursivePostOrder(TreeNode<Integer> root) {
        if (null == root) return;
        recursivePostOrder(root.left);
        recursivePostOrder(root.right);
        System.out.print(root.data);
    }

    public void iterativePostOrder(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> current = root;
        while (!stack.isEmpty() || null != current) {
            if (null != current) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode<Integer> temp = stack.peek().right;
                if (null == temp) {
                    temp = stack.pop();
                    System.out.print(temp.data);
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.data);
                    }
                } else {
                    current = temp;
                }
            }
        }
    }

    public void iterativeLevelOrder(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new Queue<>();
        TreeNode<Integer> node = root;
        queue.enqueue(node);
        while (!queue.isEmpty()) {
            node = queue.dequeue();
            System.out.print(node.data);
            if (null != node.left) queue.enqueue(node.left);
            if (null != node.right) queue.enqueue(node.right);
        }
    }

    public int findMax(TreeNode<Integer> node, int max) {
        if (max < node.data) max = node.data;
        if (null != node.left) max = findMax(node.left, max);
        if (null != node.right) max = findMax(node.right, max);
        return max;
    }
}
