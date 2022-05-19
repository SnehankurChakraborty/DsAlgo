package com.dsalgo.datastructure.queues;

import java.util.NoSuchElementException;

public class Queue<T> {

    private Node<T> front;
    private Node<T> rear;
    private int length = 0;

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

    public void enqueue(T data) {
        Node<T> node = new Node<>(data);
        if (this.isEmpty()) {
            this.front = node;
        } else {
            this.rear.next = node;
        }
        this.rear = node;
        this.length++;
    }

    public T dequeue() {
        if (this.isEmpty()) throw new NoSuchElementException();
        Node<T> pointer = this.front;
        this.front = this.front.next;
        if(this.front == null){
            this.rear = null;
        }
        this.length--;
        return pointer.data;
    }

    public T peek() {
        return this.front.data;
    }

    public void display(){
        Node<T> pointer = this.front;
        while (null != pointer){
            System.out.print(pointer.data+"->");
            pointer = pointer.next;
        }
        System.out.println("null");
    }

    public int getSize(){
        return this.length;
    }
}
