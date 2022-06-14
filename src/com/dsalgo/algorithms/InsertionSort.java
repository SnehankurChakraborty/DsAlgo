package com.dsalgo.algorithms;

import java.util.Currency;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 3, 1, 8, 7, 6, 4};
        long start = System.currentTimeMillis();
        IntStream.of(insertionSort(arr)).forEach(System.out::println);
        System.out.println("time taken ->" +(System.currentTimeMillis()-start));
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int num = arr[i];
            while (j > 0) {
                if (arr[j] < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    arr[j - 1] = num;
                }
                j--;
            }
            //System.out.println("Array -> " + IntStream.of(arr).boxed().toList());
        }
        return arr;
    }
}
