package leetcode.java.general;


import java.util.HashMap;

/*
https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109


Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class MajorityElement {


    // Assumptions: there is only one element that appears more than n / 2
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        int highestMajority = 0;
        int highestMajorityHolder = nums[0];
        int current = 0;
        for(int i = 0; i <= nums.length - 1; i++) {
            current = nums[i];
            sums.compute(current, (key, value) -> (value == null) ? 1 : value + 1);
            if (sums.get(current) > highestMajority) {
                highestMajority = sums.get(current);
                highestMajorityHolder = current;
            }
        }
        return highestMajorityHolder;
    }


    public static void main(String[] args) {
        int[] input = {3,2,3};
        int result = majorityElement(input);
        System.out.println(result);
    }
}
