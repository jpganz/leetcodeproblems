package leetcode.java.general;


/*
https://leetcode.com/problems/meeting-rooms-ii/description/
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Integer earliest;
        for(int i = 0; i < intervals.length; i++) {
            earliest = queue.peek();
            if(earliest != null && earliest <= intervals[i][0]) {
                queue.poll();// remove the earliest and now we add a new meeting room
                queue.add(intervals[i][1]);
            } else {
                queue.add(intervals[i][1]);
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {
        int[][] schedule = {{6,15}, {13,20}, {15,20}, {18, 22}};
        int response = minMeetingRooms(schedule);
        System.out.println("The result is " + response);
    }
}

