package leetcode.java.general;


/*
https://leetcode.com/problems/sort-characters-by-frequency/description/
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {


    public static String frequencySort(String s) {
        // if characters are already put together on any order, but together, I can skip this part
        char[] splittedInput = s.toCharArray();
        Arrays.sort(splittedInput); // log N


        //String reOrderedString = s;
        Comparator<String> myComparator = Comparator.comparingInt(String::length).reversed();
        PriorityQueue<String> orderedQueue = new PriorityQueue<>(myComparator);
        // split the string by same character and push it to the queue
        // poll one by one and thats it :)
        char placeholder = splittedInput[0];
        StringBuilder concatenatedPlaceholder = new StringBuilder();
        concatenatedPlaceholder.append(placeholder);
        for(int i = 1; i < s.length(); i++) { // log N
            if(placeholder != splittedInput[i]) {
                //orderedQueue.add(concatenatedPlaceholder);
                orderedQueue.add(concatenatedPlaceholder.toString());
                //concatenatedPlaceholder = "" + splittedInput[i];
                concatenatedPlaceholder = new StringBuilder();
                concatenatedPlaceholder.append(splittedInput[i]);
                placeholder = splittedInput[i];

            } else {
                concatenatedPlaceholder.append(splittedInput[i]);
            }
        }
        orderedQueue.add(concatenatedPlaceholder.toString());

        StringBuilder response = new StringBuilder();
        while(!orderedQueue.isEmpty()) {
            response.append(orderedQueue.poll());
        }

        return response.toString();
    }

    // cccaaa -> aaaccc or cccaaa
    // ccaaa -> aaacc
    // cccaa -> cccaa


    public static void main(String[] args) {
        String input = "raaeaedere"; // result eeeeaaarrd
        String output = frequencySort(input);
        System.out.println("the output is " + output);
//        String[] test = "ccccaaa".split("");
//        Arrays.sort(test);
//        System.out.println(Arrays.toString(test));
    }
}

