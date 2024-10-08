package leetcode.java.general;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
https://leetcode.com/problems/roman-to-integer/

 */
public class RomanNumbers {


    // Assumptions: Only one valid answer exists.
    // Brute force O(n^2)
    public static int romanToInt(String s) {
        //adding a dictionary
        HashMap<String, Integer> dictionary = new HashMap<>();
        dictionary.put("I", 1);
        dictionary.put("V", 5);
        dictionary.put("X", 10);
        dictionary.put("L", 50);
        dictionary.put("C", 100);
        dictionary.put("D", 500);
        dictionary.put("M", 1000);

        String[] splitted = s.split("");

        int summatory = 0;

        int counter = splitted.length - 1;

        while(counter >= 0){
            if(counter > 0 && dictionary.get(splitted[counter]) > dictionary.get(splitted[counter - 1])) {
                summatory += dictionary.get(splitted[counter]) - dictionary.get(splitted[counter - 1]);
                counter --;
            } else {
                summatory += dictionary.get(splitted[counter]);
            }
            counter --;
        }



        return summatory;
    }




    public static void main(String[] args) {
        int result = romanToInt("MCMXCIV");
        System.out.println(" the result is " + result);
    }
}
