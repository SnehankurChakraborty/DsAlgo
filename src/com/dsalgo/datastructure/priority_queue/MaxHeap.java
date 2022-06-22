package com.dsalgo.datastructure.priority_queue;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap(int size) {
        this.heap = new int[size + 1];
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void insert(int data) {
        if (this.size == this.heap.length - 1) {
            resize(2 * this.heap.length);
        }
        this.heap[++this.size] = data;
        swim(this.size);
    }

    private void swim(int depth) {
        while (depth > 1 && this.heap[depth / 2] < this.heap[depth]) {
            int temp = this.heap[depth];
            this.heap[depth] = this.heap[depth / 2];
            this.heap[depth / 2] = temp;
            depth = depth / 2;
        }
    }

    @Override
    public String toString() {
        return IntStream.of(this.heap).boxed().toList().toString();
    }

    private void resize(int size) {
        int[] temp = new int[size];
        for (int i = 0; i <= this.size; i++) {
            temp[i] = this.heap[i];
        }
        this.heap = temp;
    }

    public int deleteMax() {
        int max = this.heap[1];
        sink();
        if (this.size > 0 && this.size == ((this.heap.length - 1) / 2)) {
            resize(this.heap.length / 2);
        }
        return max;
    }

    private void sink() {
        int i = 1;
        this.heap[1] = this.heap[this.size];
        this.heap[this.size] = 0;
        this.size--;

        while ((2 * i) <= this.size) {
            int pos = 2 * i;
            if (pos + 1 <= this.size) pos = this.heap[pos] > this.heap[pos + 1] ? pos : pos + 1;
            if (this.heap[pos] > this.heap[i]) {
                int temp = this.heap[pos];
                this.heap[pos] = this.heap[i];
                this.heap[i] = temp;
            }
            i = pos;
        }
    }
}
