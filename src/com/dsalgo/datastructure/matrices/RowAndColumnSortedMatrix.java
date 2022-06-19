package com.dsalgo.datastructure.matrices;

public class RowAndColumnSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 51}};
        System.out.println(findPos(matrix,32));
    }

    private static String findPos(int[][] matrix, int num) {

        int i = 0, j = matrix.length - 1;
        while (i < matrix.length && j >= 0) {
            System.out.println(matrix[i][j]);
            if (num == matrix[i][j]) return i + "," + j;
            if (num < matrix[i][j]) j--;
            else i++;
        }
        return "not found";
    }
}
