package leetcode.java.general;


/*
https://leetcode.com/problems/valid-parentheses/description/
 */

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {


    public static boolean isValid(String s) {
        if(s.length() % 2 == 1) return false;

        Stack<Character> stack = new Stack<>();
        boolean output = true;

        HashMap<Character, Character> pairs = new HashMap<>();
        pairs.put('(', ')');
        pairs.put('{', '}');
        pairs.put('[', ']');

        HashMap<Character, Character> reversedPairs = new HashMap<>();
        reversedPairs.put(')', '(');
        reversedPairs.put('}', '{');
        reversedPairs.put(']', '[');


        for(int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if(pairs.containsKey(current)) {
                stack.push(current);
            } else {
                if(!stack.isEmpty()) {
                    Character previous = stack.pop();
                    if(reversedPairs.get(current) != previous) {
                        output = false;
                        break;
                    }
                } else {
                    output = false;
                    break;
                }
            }
        }

        return output && stack.isEmpty();
    }


    public static void main(String[] args) {
        boolean output = isValid("(}");
        System.out.println("the result is " + output);
    }
}

