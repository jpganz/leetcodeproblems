package leetcode.java.general;


/*
https://leetcode.com/problems/container-with-most-water/description
 */


public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int maxArea = 0;
        while(leftPointer < rightPointer) {
            maxArea = Math.max(maxArea, (rightPointer - leftPointer) * Math.min(height[leftPointer], height[rightPointer]));
            if(height[leftPointer] < height[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] input = {1,8,6,2,5,4,8,3,7};
        var output = maxArea(input);
        System.out.println("the output is " + output);

    }


}
