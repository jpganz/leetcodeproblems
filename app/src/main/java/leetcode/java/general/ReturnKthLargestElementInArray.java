package leetcode.java.general;


/*
https://leetcode.com/problems/add-two-numbers/description/

 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReturnKthLargestElementInArray {

    public static int findKthLargest(int[] nums, int k) {
        Comparator comparator = Comparator.reverseOrder();
        PriorityQueue<Integer> maxHeap= new PriorityQueue<>(comparator);
        for(int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }

        int kthValue = maxHeap.peek();
        for(int j = 0; j < k; j++) {
            kthValue = maxHeap.poll();
        }
        return kthValue;
    }



    // 9 - 9 - 9 - 9
    // 9 - 9
    // 8 - 9 - 10

    public static void main(String[] args) {
        int[] input = {3};
        int k = 1;
        int output = findKthLargest(input, k);
        System.out.println("The result is " + output);
    }
}

