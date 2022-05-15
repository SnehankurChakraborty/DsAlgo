package com.dsalgo.datastructure.linkedlists;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList() {
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public DoublyLinkedList insertEnd(int data) {
        Node node = new Node(data);
        if (this.isEmpty()) {
            this.head = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
        }
        this.tail = node;
        length++;
        return this;
    }

    public DoublyLinkedList insertStart(int data) {
        Node node = new Node(data);
        if (!this.isEmpty()) {
            node.next = this.head;
            node.prev = this.head.prev;
            this.head.prev = node;
        }
        this.head = node;
        length++;
        return this;
    }

    public void display() {
        Node pointer = this.head;
        while (null != pointer) {
            System.out.print(pointer.data + "->");
            pointer = pointer.next;
        }
        System.out.print("null");
    }

    public static class Node {
        private int data;
        private Node next;
        private Node prev;

        public Node(int data) {
            this.data = data;
        }
    }
}
