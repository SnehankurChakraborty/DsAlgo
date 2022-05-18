package com.dsalgo.datastructure.stacks;

import java.util.EmptyStackException;

public class Stack<T> {

    private Node<T> top;
    private int length;

    public Stack() {
        this.top = null;
    }

    public static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public Stack<T> push(T data) {
        Node<T> node = new Node<>(data);
        node.next = this.top;
        this.top = node;
        length++;
        return this;
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        Node<T> node = this.top;
        this.top = node.next;
        length--;
        return node.data;
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return this.top.data;
    }

    public void display() {
        Node<T> pointer = this.top;
        while (null != pointer) {
            System.out.print(pointer.data + "-->");
            pointer = pointer.next;
        }
        System.out.println("null");
    }
}
