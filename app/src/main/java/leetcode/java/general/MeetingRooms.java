package leetcode.java.general;


/*
https://leetcode.com/problems/meeting-rooms/description/
 */

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {


    public static boolean canAttendMeetings(int[][] intervals) {
        //Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0])); // this is faster! :O
        for (int i=0; i < intervals.length -1; i++) {
            if(intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        int[][] schedule = {{5,10}, {4,30}, {15,20}};
        boolean response = canAttendMeetings(schedule);
        System.out.println("The result is " + response);
    }
}

