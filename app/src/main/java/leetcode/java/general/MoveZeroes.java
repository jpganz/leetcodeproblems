package leetcode.java.general;


/*
https://leetcode.com/problems/move-zeroes/description
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MoveZeroes {

    // 0, 3, 0, 2, 0, 3
    public static void moveZeroesBubbleSortish(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                int counter = i + 1;
                while (counter < nums.length) {
                    if (nums[counter] != 0) {
                        nums[i] = nums[counter];
                        nums[counter] = 0;
                        break;
                    }
                    counter++;
                }
            }
        }
    }

    //using a queue is more efficient, but not on the top expected
    public static void moveZeroesWithQueue(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                queue.add(i);
            } else if (!queue.isEmpty()) {
                nums[queue.poll()] = nums[i];
                nums[i] = 0;
                queue.add(i);
            }
        }
    }

    public static void moveZeroes(int[] nums) {
        // 1, 2, 0, 3
        int counterDigits = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != counterDigits) {
                    nums[counterDigits] = nums[i];
                    nums[i] = 0;
                }
                counterDigits++;
            }
        }
    }


    public static void main(String[] args) {
        int[] input = {2, 1};
        moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }
}

