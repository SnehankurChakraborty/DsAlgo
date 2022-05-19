package com.dsalgo.datastructure.queues;

public class QueueTest {

    public static void main(String[] args) {
        //queueOps();
        binaryNumbers(7);

    }

    private static void queueOps() {
        Queue<Integer> queue = new Queue<>();
        queue.display();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.display();
        queue.dequeue();
        queue.display();
        queue.dequeue();
        queue.display();
    }

    private static void binaryNumbers(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        Queue<String> queue = new Queue<>();
        queue.enqueue("1");
        for (int i = 0; i < n; i++) {
            String top = queue.dequeue();
            System.out.println(top);
            String n1 = top + "0";
            String n2 = top + "1";
            queue.enqueue(n1);
            queue.enqueue(n2);
        }
    }

}
