package leetcode.java.general;

/*
https://leetcode.com/problems/longest-common-prefix/description/
 */

import java.util.HashSet;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        boolean notEmpty = true;
        int counter = 0;
        StringBuilder prefix = new StringBuilder();
        while(notEmpty) {
            HashSet<Character> characters = new HashSet<>();
            boolean emptyString = false;
            for(String input: strs) {
                if(input.length() > counter) {
                    characters.add(input.charAt(counter));
                } else {
                    emptyString = true;
                }
            }
            if(characters.size() == 1 && emptyString == false) { // they all are the same
                prefix.append(characters.stream().findFirst().get());
            } else {
                notEmpty = false;
            }
            counter ++;
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        String output = longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println(output);
    }

}
