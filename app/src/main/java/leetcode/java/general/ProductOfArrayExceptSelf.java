package leetcode.java.general;


import java.util.Arrays;

/*
https://leetcode.com/problems/product-of-array-except-self/description
 */
public class ProductOfArrayExceptSelf {


    //lets do bruteforce
    public static int[] productExceptSelf(int[] nums) {
        int output[] = new int[nums.length];
        int leftAccumulator[] = new int[nums.length];
        leftAccumulator[0] = 1;
        int rightAccumulator[] = new int[nums.length];
        rightAccumulator[nums.length - 1] = 1;

        for(int i = 1; i < nums.length; i++){
            leftAccumulator[i] = leftAccumulator[i - 1] * nums[i - 1];
        }

        for(int i = nums.length - 2; i >= 0; i--){
            rightAccumulator[i] = rightAccumulator[i + 1] * nums[i + 1];
        }

        System.out.println(Arrays.toString(leftAccumulator));
        System.out.println(Arrays.toString(rightAccumulator));

        for(int i = 0; i < nums.length; i++) {
            output[i] = leftAccumulator[i] * rightAccumulator[i];
        }

        return output;
    }



    public static void main(String[] args) {
        int[] input = {4, 5, 1, 8, 2, 10, 6}; // 0, 0, 9, 0, 0

        int[] output = productExceptSelf(input);
        System.out.println("the output is " + Arrays.toString(output));

    }
}
