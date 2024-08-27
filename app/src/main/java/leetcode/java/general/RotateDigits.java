package leetcode.java.general;


/*
https://leetcode.com/problems/rotated-digits/description/
 */

import java.util.HashMap;

public class RotateDigits {


    public static int rotatedDigits(int n) {

        int counter = 0;
        for(int i = 1; i <= n; i++) {
            if(isValid(i)) counter++;
        }
        return counter;
    }

    private static boolean isValid(int input) {
    // Valid if N contains at least  2, 5, 6, 9
    // Invalid if contains one of 3, 4, 7
        boolean isValid = false;
        while(input > 0) {
            if(input % 10 == 2) isValid = true;
            if(input % 10 == 5) isValid = true;
            if(input % 10 == 6) isValid = true;
            if(input % 10 == 9) isValid = true;
            if(input % 10 == 3) return false;
            if(input % 10 == 4) return false;
            if(input % 10 == 7) return false;
            input = input / 10;
        }
        return isValid;
    }

    public static void main(String[] args) {
        System.out.println(rotatedDigits(857));
    }
}

