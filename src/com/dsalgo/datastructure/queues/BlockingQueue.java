package com.dsalgo.datastructure.queues;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {

    private LinkedList<T> queue;
    private int size;
    final Lock lock = new ReentrantLock();
    final Condition producer = lock.newCondition();
    final Condition consumer = lock.newCondition();

    public BlockingQueue(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
    }

    public void addPrimitive(T element) throws InterruptedException {
        synchronized (this){
            while(this.queue.size() == this.size){
                System.out.println("Waiting for consumer now");

                wait();
            }
            System.out.println("pushed->"+element);
            this.queue.push(element);
            notifyAll();
        }
    }

    public T removePrimitive() throws InterruptedException {
        T element;
        synchronized (this){
            while(this.queue.size() == 0){
                System.out.println("Waiting for producer now");
                wait();
            }
            element = this.queue.pollFirst();
            System.out.println("polled ->"+element);
            notifyAll();
        }
        return element;
    }

    public void add(T element) throws InterruptedException {
        lock.lock();
        while (this.queue.size() == this.size) {
            System.out.println("Waiting for consumer now");
            producer.await();
        }
        System.out.println("pushing ->"+element);
        this.queue.push(element);
        this.size++;
        consumer.signal();
        lock.unlock();

    }

    public T remove() throws InterruptedException {
        lock.lock();
        while (this.queue.size() == 0) {
            System.out.println("Waiting for producer now");
            consumer.await();

        }
        T element = this.queue.pollFirst();
        System.out.println("polled ->"+element);
        this.size--;
        producer.signal();
        lock.unlock();
        return element;

    }
}
