package leetcode.java.general;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/reverse-words-in-a-string/description
 */
public class ReversingWords {


    public static String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder output = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            output.append(words[i]);
            output.append(" ");
        }
        return output.toString().trim();
    }

    public static void main(String[] args) {
        String input = "the sky is  blue";
        String output = reverseWords(input);
        System.out.println("the output is " + output);

    }
}
