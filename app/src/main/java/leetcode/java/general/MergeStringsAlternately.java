package leetcode.java.general;


/*
https://leetcode.com/problems/fibonacci-number/description/
 */


public class MergeStringsAlternately {


    public static String mergeAlternately(String word1, String word2) {
        int maxLenght = Math.max(word1.length(), word2.length());
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < maxLenght; i++) {
            if(i < word1.length()) {
                output.append(word1.charAt(i));
            }
            if(i < word2.length()) {
                output.append(word2.charAt(i));
            }
        }
        return output.toString();
    }


    public static void main(String[] args) {
        String output = mergeAlternately("ab", "pqrs");
        System.out.println(output);

    }


}
