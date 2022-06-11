package com.dsalgo.algorithms;

import com.dsalgo.datastructure.array.Arrays;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 3, 1, 8, 7, 6, 4};
        IntStream.of(bubbleSort(arr)).forEach(System.out::println);

    }

    public static int[] bubbleSort(int[] arr) {
        int i = arr.length;
        while (i > 0) {
            for (int j = 1; j < i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
            i--;
        }
        return arr;
    }
}
