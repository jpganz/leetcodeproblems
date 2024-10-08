package leetcode.java.general;


import java.util.Arrays;
import java.util.HashMap;

/*
https://leetcode.com/problems/palindrome-number/description/


 */
public class PalindromeNumber {


    //approach 1: reversing half the number
    public static boolean isPalindrome2(int x) {
        if(x < 0 || (x >= 10 && x % 10 == 0 )) {
            return false;
        } else {
            String equivalent = String.valueOf(x);
            int loopLenght = (equivalent.length() / 2) + (equivalent.length() % 2);
            int outerLoop = equivalent.length() - 1;
            for(int i = 0; i < loopLenght; i++ ) {
                if(equivalent.charAt(i) != equivalent.charAt(outerLoop)){
                    return false;
                } else {
                    outerLoop--;
                }
            }
            return true;
        }
    }


    //approach 2: using the modular operator
    public static boolean isPalindrome(int x) {
        if(x < 0 || (x >= 10 && x % 10 == 0 )) {
            return false;
        } else {
            int lastDigit;
            int reversedNumber = x;
            int createdPalindrome = 0;
            int multiplier = 10;
            while(reversedNumber > 0) {
                lastDigit = reversedNumber % 10;
                createdPalindrome = (multiplier * createdPalindrome) + lastDigit;
                reversedNumber /= 10;
            }
            return (x == createdPalindrome);
        }
    }


    public static void main(String[] args) {
        boolean isBoolean = isPalindrome(123); //3 * 10 + 2 = 32  ; 32 * 10 + 1
        System.out.println("Is it palindrome? " + isBoolean);

    }
}
