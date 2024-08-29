package leetcode.java.general;


/*
https://leetcode.com/problems/climbing-stair
 */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ClimbingStairs {


    public static int climbStairs(int n) {
        Set<int[]> combinations = new HashSet<>();
        if(n == 1) return 1;


        int[] values = new int[n+1];
        values[1] = 1;
        values[2] = 2;
        for(int i = 3; i <= n; i++) {
            values[i] = values[i-1] + values[i - 2];
        }

        return values[n];
    }




    public static void main(String[] args) {


        var output = climbStairs(5);
        System.out.println("the output is " + output);

    }


}
