package leetcode.java.general;


import java.util.Arrays;
import java.util.HashMap;

/*
https://leetcode.com/problems/maximum-subarray/description/


 */
public class MaximumSubarray {

    // using Kadane's algorithm
    public static int maxSubArray(int[] nums) {
        int currentMaxValue = nums[0]; // assuming the array is not null
        int currentSubArray = nums[0];
        int current;

        for(int i = 1; i < nums.length; i++) {
            current = nums[i];
            currentSubArray = Math.max(currentSubArray + current, current);
            currentMaxValue = Math.max(currentMaxValue, currentSubArray);
        }
        return currentMaxValue;
    }


    public static void main(String[] args) {
        int[] input = {-2,3,1,3};
        int maxValue = maxSubArray(input);
        System.out.println(maxValue);
    }
}
