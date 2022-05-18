package com.dsalgo.datastructure.strings;

public class Strings {
    public static void main(String[] args) {
        checkPalindrome("m");
    }

    private static void checkPalindrome(String str){
        char[] arr = str.toCharArray();
        boolean isPalindrome = true;
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            if(arr[start] != arr[end]){
                isPalindrome = false;
                break;
            }
            start ++;
            end --;
        }
        System.out.println("Is Palindrome: "+ isPalindrome);
    }
}
