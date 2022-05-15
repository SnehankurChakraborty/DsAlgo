package com.dsalgo.datastructure.linkedlists;

public class CircularSinglyLinkedList {

    private Node last;

    public CircularSinglyLinkedList() {
        this.last = null;
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public CircularSinglyLinkedList insertAtEnd(int data) {
        Node node = new Node(data);
        if (null != this.last) {
            node.next = this.last.next;
            this.last.next = node;
        } else {
            node.next = node;
        }
        this.last = node;
        return this;
    }

    public CircularSinglyLinkedList insertAtStart(int data) {
        Node pointer = this.last.next;
        Node node = new Node(data);
        node.next = pointer;
        this.last.next = node;
        return this;
    }

    public void display() {
        Node pointer = this.last;
        while (null != pointer && this.last != pointer.next) {
            pointer = pointer.next;
            System.out.print(pointer.data + "->");
        }
        System.out.println(null != this.last? this.last.data: "null");
    }
}
