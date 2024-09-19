package leetcode.java.general;


/*
https://leetcode.com/problems/string-compression/
 */


public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        if(s.isEmpty()) return true;
        for (int i = 0; i < t.length(); i++) {
            if (sIndex < s.length() && s.charAt(sIndex) == t.charAt(i)) {
                sIndex++;
                if (sIndex == s.length()) return true;
            }

        }
        return sIndex == s.length();
    }

    public static void main(String[] args) {

        var output = isSubsequence("axc", "ahbgdc");
        System.out.println("the output is " + output);

    }


}
