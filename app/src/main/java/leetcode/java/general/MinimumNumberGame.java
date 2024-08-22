package leetcode.java.general;


/*
https://leetcode.com/problems/minimum-number-game/description/
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumNumberGame {


    public static int[] numberGame(int[] nums) {

        PriorityQueue<Integer> myQueue = new PriorityQueue<Integer>(nums.length);
        int[] gameArray = new int[nums.length];
        int bobNumber;
        int aliceNumber;
        // filling the priority queue;
        for(int i = 0; i < nums.length; i++) {
            myQueue.add(nums[i]);
        }

        int counter = 0;
        while(!myQueue.isEmpty()) {
            aliceNumber = myQueue.poll();
            bobNumber = myQueue.poll();
            gameArray[counter] = bobNumber;
            counter++;
            gameArray[counter] = aliceNumber;
            counter++;
        }
        return gameArray;

    }

    public static int[] numberGameWithArrays(int[] nums) {

        Arrays.sort(nums);
        int[] output = new int[nums.length];
        // filling the priority queue;
        int counter = 0;
        while (counter < nums.length) {
            output[counter] = nums[counter + 1];
            counter ++;
            output[counter] = nums[counter - 1];
            counter++;
        }
        return output;
    }

    // for input 5,4,2,3 the expected output is: 3,2,5,4

    public static void main(String[] args) {
        int[] input = {5,4,2,3};
        int[] output = numberGame(input);
        int[] output2 = numberGameWithArrays(input);
        System.out.println(Arrays.toString(output));
        System.out.println(Arrays.toString(output2));
    }
}

