package com.dsalgo.algorithms;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 3, 1, 8, 7, 6, 4};
        System.out.println(IntStream.of(quickSort(arr, 0, arr.length)).boxed().collect(Collectors.toList()));
    }


    public static int[] quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = pivotArray(arr, start, end);
            quickSort(arr, start, pivot);
            quickSort(arr,  pivot + 1, end);
        }
        return arr;
    }

    public static int pivotArray(int[] arr, int start, int end) {
        int pivot = arr[end - 1];
        int j = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        System.out.println(IntStream.of(arr).boxed().collect(Collectors.toList()));
        return j-1;
    }
}
