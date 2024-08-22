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
        String[] splittedString = s.split("");
        Arrays.sort(splittedString); // log N
        String reOrderedString = String.join("", splittedString); // o(n)

        //String reOrderedString = s;
        Comparator<String> myComparator = Comparator.comparingInt(String::length).reversed();
        PriorityQueue<String> orderedQueue = new PriorityQueue<>(myComparator);
        // split the string by same character and push it to the queue
        // poll one by one and thats it :)
        char placeholder = reOrderedString.charAt(0);
        String concatenatedPlaceholder = "" + placeholder;
        for(int i = 1; i < s.length(); i++) { // log N

            if(placeholder != reOrderedString.charAt(i)) {
                orderedQueue.add(concatenatedPlaceholder);
                concatenatedPlaceholder = "" + reOrderedString.charAt(i);
                placeholder = reOrderedString.charAt(i);

            } else {
                concatenatedPlaceholder += reOrderedString.charAt(i);
            }
        }
        orderedQueue.add(concatenatedPlaceholder);

        String response = "";
        while(!orderedQueue.isEmpty()) {
            response += orderedQueue.poll();
        }

        return response;
    }

    // cccaaa -> aaaccc or cccaaa
    // ccaaa -> aaacc
    // cccaa -> cccaa


    public static void main(String[] args) {
        String input = "raaeaedere";
        String output = frequencySort(input);
        System.out.println("the output is " + output);
//        String[] test = "ccccaaa".split("");
//        Arrays.sort(test);
//        System.out.println(Arrays.toString(test));
    }
}

