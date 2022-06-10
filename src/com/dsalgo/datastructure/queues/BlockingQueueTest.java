package com.dsalgo.datastructure.queues;

import java.util.stream.IntStream;

public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>(10);
        Runnable t1 = ()-> {

                IntStream.range(0,10).forEach( i -> {
                    try {
                        blockingQueue.remove();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });


        };

        Runnable t2 = ()-> {
            IntStream.range(0,10).forEach( i -> {
                try {
                    blockingQueue.add(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        };

        Runnable t3 = ()-> {

            IntStream.range(0,10).forEach( i -> {
                try {
                    blockingQueue.removePrimitive();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });


        };

        Runnable t4 = ()-> {
            IntStream.range(0,10).forEach( i -> {
                try {
                    blockingQueue.addPrimitive(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        };

        Thread t = new Thread(t2);

        new Thread(t1).start();
        t.start();
        t.join();

        new Thread(t3).start();
        new Thread(t4).start();


    }
}
