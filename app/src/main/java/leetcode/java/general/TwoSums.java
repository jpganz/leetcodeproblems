package leetcode.java.general;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/two-sum



 */
public class TwoSums {


    // Assumptions: Only one valid answer exists.
    // Brute force O(n^2)
    public static int[] twoSum(int[] nums, int target) {
        int[] sumIndexes = new int[2];
        for(int i = 0; i <= nums.length - 2; i++) {
            for(int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    sumIndexes[0] = i;
                    sumIndexes[1] = j;
                }
            }
        }
        return sumIndexes;
    }



    // doing hashmaps will be O(n)
    public static int[] twoSumWithHashes(int[] nums, int target) {
        HashMap<Integer, Integer> mapOfValueIndex = new HashMap<>();

        int pendingKey;
        for(int j = 0; j <= nums.length - 1; j++) {

            pendingKey = target - nums[j];
            if(mapOfValueIndex.containsKey(pendingKey) && mapOfValueIndex.get(pendingKey) != j) {
                return new int[]{mapOfValueIndex.get(pendingKey), j};
            }
            mapOfValueIndex.put(nums[j], j);

        }

        return new int[]{};
    }





    public static void main(String[] args) {
        int[] input = {3,3,2};
        int[] returnedValues = twoSum(input, 6);
        int[] returnedValues2 = twoSumWithHashes(input, 6);
        System.out.println(Arrays.toString(returnedValues));
        System.out.println(Arrays.toString(returnedValues2));

    }
}
