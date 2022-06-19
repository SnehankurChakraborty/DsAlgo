package com.dsalgo.datastructure.matrices;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}};

        int row = matrix.length;
        int column = matrix.length;
        int i = 0, j = 0;
        while (i < row && j < column) {
            for (; j < column; j++) {
                System.out.println(matrix[i][j]);

            }
            i++;
            j--;
            for (; i < row; i++) {
                System.out.println(matrix[i][j]);

            }
            i--;
            j--;
            for (; j >= matrix.length - column; j--) {
                System.out.println(matrix[i][j]);
            }
            j++;
            i--;
            row--;
            for (; i >= matrix.length - row; i--) {
                System.out.println(matrix[i][j]);
            }
            i++;
            j++;
            column--;
        }
    }
}
