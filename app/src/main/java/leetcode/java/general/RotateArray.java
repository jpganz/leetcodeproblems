package leetcode.java.general;


import java.util.HashMap;

/*
https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105


Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?


 */
public class RotateArray {


    // Assumptions: there is only one element that appears more than n / 2
    public static void rotate(int[] nums, int k) {
        int safeKey = (k % nums.length);
        HashMap<Integer, Integer> mapPositionValue = new HashMap<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            mapPositionValue.put(i, nums[i]); // setting the original order x value;
        }

        int nextKey = 0;
        for (int j = 0; j <= nums.length - 1; j++) {
            nextKey =  Math.abs((nums.length + j - safeKey) % nums.length);
            nums[j] = mapPositionValue.get(nextKey);
        }

    }

    public static void rotateSecondVersion(int[] nums, int k) {
        int safeKey = (k % nums.length);
        int[] placeHolder = new int[nums.length];

        int nextKey;
        for (int j = 0; j <= nums.length - 1; j++) {
            nextKey =  (j + safeKey) % nums.length;
            placeHolder[nextKey] = nums[j];

        }

        for (int i = 0; i <= nums.length -1; i++) {
            nums[i] = placeHolder[i];
        }
    }


    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7};
        rotateSecondVersion(input, 3);
    }
}
