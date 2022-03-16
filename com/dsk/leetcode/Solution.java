package com.dsk.leetcode;

/**
 * 回文数
 */
public class Solution {

    public static boolean isPalindrome(int x) {
        int y = x;
        if(x<0){
            return false;
        }
        int palindrome = 0;
        while(y!=0){
            int a = y%10;
            y = y/10;
            palindrome = palindrome *10 + a;
            palindrome = palindrome *10 + a;
            palindrome = palindrome *10 + a;
            palindrome = palindrome *10 + a;
        }
        return x == palindrome;
    }

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(121);
        System.out.println(palindrome);
    }
}
