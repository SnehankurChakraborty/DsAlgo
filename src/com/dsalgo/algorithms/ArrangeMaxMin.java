package com.dsalgo.algorithms;

import java.util.stream.IntStream;

public class ArrangeMaxMin {

    public static void main(String[] args) {
        int[] arr = {4, 6, 10, 34, 56, 86, 101};
        int i = 0;
        int j = arr.length - 1;
        int max = arr[arr.length - 1] + 1;
        for (int k = 0; k < arr.length; k++) {
            if (k % 2 == 0) {
                arr[k] = (arr[j] % max) * max + arr[k];
                j--;
            } else {
                arr[k] = (arr[i] % max) * max + arr[k];
                i++;
            }
        }
        for (int k = 0; k < arr.length; k++) {
            arr[k] = arr[k] / max;
        }
        IntStream.of(arr).boxed().forEach(System.out::println);
    }
}
