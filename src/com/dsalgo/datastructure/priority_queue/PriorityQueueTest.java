package com.dsalgo.datastructure.priority_queue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(1);
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(5);
        maxHeap.insert(10);
        maxHeap.insert(4);
        System.out.println(maxHeap);
        maxHeap.deleteMax();
        System.out.println(maxHeap);
        maxHeap.deleteMax();
        System.out.println(maxHeap);
        maxHeap.deleteMax();
        System.out.println(maxHeap);
        maxHeap.deleteMax();
        System.out.println(maxHeap);
        maxHeap.deleteMax();
        System.out.println(maxHeap);
        maxHeap.deleteMax();
        System.out.println(maxHeap);
    }
}
