package leetcode.java.general;


/*
https://leetcode.com/problems/string-compression/
 */


import java.util.Arrays;

public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        for (int i = 0; i < t.length(); i++) {
            if(sIndex < s.length() && s.charAt(sIndex) == t.charAt(i)) sIndex++;

        }
        return sIndex == s.length();
    }

    public static void main(String[] args) {

        var output = isSubsequence("axc", "ahbgdc");
        System.out.println("the output is " + output);

    }


}
