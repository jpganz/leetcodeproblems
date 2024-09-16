package leetcode.java.general;


/*
https://leetcode.com/problems/fibonacci-number/description/
 */


public class IncreasingTripletSubsequence {


    public static boolean increasingTriplet(int[] nums) {
        // this is three pointers problem
        int number1 = Integer.MAX_VALUE;
        int number2 = Integer.MAX_VALUE;
       for(int num:nums) {
           if(num <= number1) {
               number1 = num;
           } else if (num <= number2) {
               number2 = num;
           } else {
               return true;
           }
       }
        return false;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 0, 5};
        var output = increasingTriplet(input);
        System.out.println("the output is " + output);

    }


}
