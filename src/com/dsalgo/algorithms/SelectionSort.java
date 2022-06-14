package com.dsalgo.algorithms;

import java.util.stream.IntStream;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 3, 1, 8, 7, 6, 4};
        long start = System.currentTimeMillis();
        IntStream.of(selectionSort(arr)).forEach(System.out::println);
        System.out.println("time taken ->" +(System.currentTimeMillis()-start));
    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            int min = arr[i];
            int j = i;
            for (int k = i; k < arr.length; k++) {
                if (arr[k] < min) {
                    min = arr[k];
                    j = k;
                }
            }
            while (j > i) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[i] = min;
            //System.out.println("Array -> " + IntStream.of(arr).boxed().toList());

        }
        return arr;
    }
}
