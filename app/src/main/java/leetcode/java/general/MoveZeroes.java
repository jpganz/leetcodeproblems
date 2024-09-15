package leetcode.java.general;


/*
https://leetcode.com/problems/move-zeroes/description
 */

import java.util.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {

            if(nums[i] == 0) {
                int counter = i + 1;
                while(counter < nums.length) {
                    if(nums[counter] != 0) {
                        nums[i] = nums[counter];
                        nums[counter] = 0;
                        break;
                    }
                    counter++;
                }
            }
        }
    }


    public static void main(String[] args) {
      int[] input = {0,1,0,3,12};
      moveZeroes(input);
      System.out.println(Arrays.toString(input));
    }
}

