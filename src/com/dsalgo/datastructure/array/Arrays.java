package com.dsalgo.datastructure.array;

public class Arrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        removeEvenNumbers(arr);

        reverseArray(arr);

        findSecondMax(new int[]{5, 11, 9, 6, 10});

        moveZerosToEnd(new int[]{1,4,0,3,7,0,0,9});

    }

    public static void moveZerosToEnd(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && arr[j] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (arr[j] != 0) j++;
        }
        System.out.println("*** Move zeros to end ***");
        for (int i : arr) System.out.println(i);
    }

    public static void findSecondMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) {
                secMax = max;
                max = i;
            } else if (i > secMax)
                secMax = i;

        }
        System.out.println("*** Second max ***");
        System.out.println(secMax);
    }

    public static void reverseArray(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--)
            temp[arr.length - i - 1] = arr[i];
        System.out.println("*** Reverse array ***");
        for (int i : temp) System.out.println(i);
    }

    public static void removeEvenNumbers(int[] arr) {

        int count = 0;
        for (int i : arr) {
            if (i % 2 == 0) count++;
        }
        int[] temp = new int[count];
        count = 0;
        for (int i : arr) {
            if (i % 2 == 0) {
                temp[count] = i;
                count++;
            }
        }
        System.out.println("*** Remove odd numbers ***");
        for (int i : temp) System.out.println(i);
    }
}
