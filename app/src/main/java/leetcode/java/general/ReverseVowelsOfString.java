package leetcode.java.general;


import java.util.*;

/*
https://leetcode.com/problems/reverse-vowels-of-a-string
 */
public class ReverseVowelsOfString {

    // brute force solution with stack
    public static String reverseVowelsBruteForce(String s) {
        Stack<Character> vowels = new Stack<>();
        HashSet<Character> allowedCharacters = new HashSet<>();
        allowedCharacters.add('a');
        allowedCharacters.add('A');
        allowedCharacters.add('e');
        allowedCharacters.add('E');
        allowedCharacters.add('i');
        allowedCharacters.add('I');
        allowedCharacters.add('o');
        allowedCharacters.add('O');
        allowedCharacters.add('u');
        allowedCharacters.add('U');
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (allowedCharacters.contains(current)) vowels.push(current);
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (allowedCharacters.contains(current)) {
                output.append(vowels.pop());
            } else {
                output.append(s.charAt(i));
            }
        }
        return output.toString();
    }

    // using two pointer
    public static String reverseVowels(String s) {
        HashSet<Character> allowedCharacters = new HashSet<>();
        allowedCharacters.add('a');
        allowedCharacters.add('A');
        allowedCharacters.add('e');
        allowedCharacters.add('E');
        allowedCharacters.add('i');
        allowedCharacters.add('I');
        allowedCharacters.add('o');
        allowedCharacters.add('O');
        allowedCharacters.add('u');
        allowedCharacters.add('U');

        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        boolean finding = true;
        char[] values = s.toCharArray();

        while (finding) {
            if (allowedCharacters.contains(values[leftIndex])) {
                // I found a left character, then find the right now
                while (rightIndex >= leftIndex) {
                    if (allowedCharacters.contains(values[rightIndex])) {
                        // switch
                        char temporal = values[leftIndex];
                        values[leftIndex] = values[rightIndex];
                        values[rightIndex] = temporal;
                        rightIndex--;
                        break;
                    }
                    rightIndex--;
                }
            }
            leftIndex++;
            if (leftIndex >= rightIndex) break;
        }
        return new String(values);

    }

    public static void main(String[] args) {
        String input = "IceCreAm";
        String output = reverseVowels(input);
        System.out.println(output);

//        String input2 = "3[abc]";
//        decodeString(input2);

    }
}
