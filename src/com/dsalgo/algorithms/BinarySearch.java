package com.dsalgo.algorithms;

// Possible only on sorted arrays
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 55, 60, 70, 90};
        System.out.println(binarySearchPos(arr, 65));

    }

    public static int binarySearchPos(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == num) return mid + 1;
            if (arr[mid] > num) end = mid - 1;
            if (arr[mid] < num) start = mid + 1;
        }
        return -1;
    }
}
