package leetcode.java.general;


/*
https://leetcode.com/problems/add-two-numbers/description/

 */

import java.util.HashMap;

public class RotateDigits {


    public static int rotatedDigits(int n) {

        HashMap<Integer, Integer> validDictionary = new HashMap<>();
        validDictionary.put(2,5);
        validDictionary.put(5,2);
        validDictionary.put(6,9);
        validDictionary.put(9,6);

        HashMap<Integer, Integer> invalidDictionary = new HashMap<>();
        invalidDictionary.put(3, 3);
        invalidDictionary.put(4, 3);
        invalidDictionary.put(7, 3);

        int counter = 0;
        StringBuilder temporal = new StringBuilder();
        if(n < 2) return 0;
        for(int i = 2; i < n; i++) {
            String current = Integer.toString(i);

        }
        return n;
    }

    public static void main(String[] args) {
        rotatedDigits(10);
    }
}

