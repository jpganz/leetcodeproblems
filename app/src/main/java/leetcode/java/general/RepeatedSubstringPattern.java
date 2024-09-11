package leetcode.java.general;


/*
https://leetcode.com/problems/greatest-common-divisor-of-strings/description
 */

public class RepeatedSubstringPattern {


    public static boolean repeatedSubstringPattern(String s) {
        String duplicated = s + s;
        if(duplicated.substring(1, duplicated.length() - 1).contains(s)){
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
       var output = repeatedSubstringPattern("abab");
       System.out.println("the output is " + output);
    }
}
