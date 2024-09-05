package leetcode.java.general;

/*
https://leetcode.com/problems/ransom-note
 */

import java.util.Arrays;
import java.util.HashMap;

public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;

        int[] magazineCharsCount = new int[26];


        char[] magArray = magazine.toCharArray();
        for(char mag: magArray) {
            magazineCharsCount[mag - 97] = magazineCharsCount[mag - 97] + 1;
        }

        char[] ransomArray = ransomNote.toCharArray();
        for(char ran: ransomArray) {
            int position = ran - 97;
            if(magazineCharsCount[position] > 0) {
                magazineCharsCount[position] = magazineCharsCount[position] - 1;
            } else {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        boolean output = canConstruct("aa", "abccczzz");
        System.out.println(output);
    }

}
