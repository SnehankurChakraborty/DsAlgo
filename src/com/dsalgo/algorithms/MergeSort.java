package com.dsalgo.algorithms;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 3, 1, 8, 7, 6, 4};

        System.out.println(IntStream.of(mergeSort(arr, 0, arr.length - 1)).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    public static int[] mergeSort(int[] arr, int start, int end) {
        if (start == end) return new int[]{ arr[start] };
        return merge(mergeSort(arr, start, (start + end) / 2), mergeSort(arr, ((start + end) / 2) + 1, end));
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int[] temp = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                temp[k] = arr1[i];
                i++;
            } else if (arr2[j] < arr1[i]) {
                temp[k] = arr2[j];
                j++;
            } else {
                temp[k] = arr1[i];
                temp[k++] = arr2[j];
                i++;
                j++;
            }
            k++;
        }
        while (i < arr1.length) {
            temp[k] = arr1[i];
            k++;
            i++;
        }
        while (j < arr2.length) {
            temp[k] = arr2[j];
            k++;
            j++;
        }
        System.out.println(IntStream.of(temp).boxed().toList());
        return temp;
    }
}
