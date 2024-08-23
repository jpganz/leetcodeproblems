package leetcode.java.general;


/*
https://leetcode.com/problems/number-of-same-end-substrings/description
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class NumberOfSameEndSubstrings {

    public static int[] sameEndSubstringCount(String s, int[][] queries) {

        HashMap<Character, Integer> mapOfValues = new HashMap<>();

        char[] input = s.toCharArray();
        int[] response = new int[queries.length];
        HashMap<Integer, Integer> dictionary = new HashMap<>();
        int result = 0;
        for(int i = 0; i < queries.length; i++) {

            int[] charCount = new int[26]; // only from a - z here :)
            for(int j = queries[i][0]; j <= queries[i][1]; j++) {
                charCount[input[j] - 'a'] += 1;
            }

            Arrays.sort(charCount);

            for(int x = charCount.length - 1; x >= 0; x--) {
                int current = charCount[x];
                if(charCount[x] == 0) break;

                result += ((current * (current - 1)) / 2) + current;
            }
            response[i] = result;
            result = 0;
        }
    return  response;
    }


    public static void main(String[] args) {
        int[][] input2 = new int[][]{{0,0}, {1,4}, {2,5}, {0,5}};
        int[][] input = new int[][]{{1,4}};
        var response = sameEndSubstringCount("abcaab", input2);
        System.out.println("the answer is " + Arrays.toString(response));
    }
}

/*
public static int[] sameEndSubstringCount(String s, int[][] queries) {

        HashMap<Character, Integer> mapOfValues = new HashMap<>();

        int[] response = new int[queries.length];
        int result = 0;
        int temporal = 0;
        for(int i = 0; i < queries.length; i++) {
            String substring = new StringBuilder().append(s.substring(queries[i][0], (queries[i][1] + 1))).toString();
            for(int j = 0; j < substring.length(); j++) {
                Character current = substring.charAt(j);
                if(mapOfValues.containsKey(current)) {
                    Integer currentValue = mapOfValues.get(current) + 1;
                    mapOfValues.put(current, currentValue);
                } else {
                    mapOfValues.put(current, 1);
                }
            }
            result = 0;
            temporal = 0;

            for(int value : mapOfValues.values()) {
                if(value == 1) {
                    result++;
                } else {
                    temporal = ((value * (value - 1)) / 2) + value;
                    result += temporal;
                }
            }
            mapOfValues = new HashMap<>();
            response[i] = result;

        }
    return  response;
    }
 */