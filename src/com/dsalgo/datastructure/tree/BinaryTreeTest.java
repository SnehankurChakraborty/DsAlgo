package com.dsalgo.datastructure.tree;

import javax.swing.tree.TreeNode;

public class BinaryTreeTest {
    public static void main(String[] args) {
        /*BinaryTree binaryTree = new BinaryTree();
        binaryTree.recursivePreOrder(binaryTree.getRoot());
        System.out.println("\n*********");
        binaryTree.iterativePreOrder(binaryTree.getRoot());
        System.out.println("\n*********");
        binaryTree.recursiveInOrder(binaryTree.getRoot());
        System.out.println("\n*********");
        binaryTree.iterativeInOrder(binaryTree.getRoot());
        System.out.println("\n*********");
        binaryTree.recursivePostOrder(binaryTree.getRoot());
        System.out.println("\n*********");
        binaryTree.iterativePostOrder(binaryTree.getRoot());
        System.out.println("\n*********");
        binaryTree.iterativeLevelOrder(binaryTree.getRoot());
        System.out.println("\n*********");
        System.out.println(binaryTree.findMax(binaryTree.getRoot(), Integer.MIN_VALUE));*/


        BinarySearchTree binarySearchTree = new BinarySearchTree(6);
        //binarySearchTree.insert(3);
        binarySearchTree.insert(9);
        binarySearchTree.insert(7);
        binarySearchTree.insert(2);
        binarySearchTree.iterativeLevelOrder();
        System.out.println(binarySearchTree.validateBinaryTree());
    }


}
