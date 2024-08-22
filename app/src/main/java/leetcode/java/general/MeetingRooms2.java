package leetcode.java.general;


/*
https://leetcode.com/problems/meeting-rooms-ii/description/
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {


    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(10);
        queue.add(8);
        queue.add(12);
        int totalMaxRooms = 1;
        int maxRooms = 1;
        System.out.println("the interval is " + (intervals.length -1));
        for(int i=0; i < intervals.length - 1; i++) {
            maxRooms = 1;
            for(int j=i + 1; j<intervals.length; j++) {
//                System.out.println("comparint " + i + " with " + j);
                System.out.println("values " + intervals[i][1] + " with " + intervals[j][0]);
                if(intervals[i][1] > intervals[j][0]) { // meaning they crash
                    maxRooms++;
                }
            }
            System.out.println("the end of this loop " + i + " got this value" + maxRooms);
            totalMaxRooms = Math.max(maxRooms, totalMaxRooms);
        }
        return totalMaxRooms;
    }

// 5,10 - 8, 30 - 15, 20

    public static void main(String[] args) {
        int[][] schedule = {{0,30}, {5,10}, {15,20}};
        int response = minMeetingRooms(schedule);
        System.out.println("The result is " + response);
    }
}

