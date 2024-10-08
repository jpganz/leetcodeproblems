package leetcode.java.general;



import java.util.Stack;

/*
https://leetcode.com/problems/decode-string/description/


 */
public class DecodeString {

    public static String decodeString(String s) {
        Stack<Character> myStack = new Stack<>();
        char current;
        String currentString = "";
        String currentNumber = "";
        for(int i = 0; i < s.length(); i++ ){
            current = s.charAt(i);
            if(current != ']') {
                myStack.push(current);
            } else {
                // loop until find [, that will be the end of my current string
                // then loop until current is no longer a number
                // then you will have a number x string that need to repeat
                // then push it all back to the stack :) and have fun
                current = myStack.pop();
                while(current != '[') {
                    currentString = current + currentString;
                    current = myStack.pop();
                }
                // here current string should contain my substring
                // now I will iterate until current is no longer a number...
                current = myStack.pop();
                while(Character.isDigit(current)) {
                    currentNumber = current + currentNumber;
                    if (myStack.isEmpty()) break;
                    current = myStack.pop();
                }
                // at this point, I can have the a of a2[bc], so, I should put it back...
                if (!myStack.isEmpty()) myStack.push(current);
                // now I should push back the extended string with currentNumber * currentString and refresh the variables...
                String expandedString = expandString(currentNumber, currentString);
                pushValues(myStack, expandedString);
                currentString = "";
                currentNumber = "";
            }
        }
        //now we put all this into a string :)
        String response = "";
        char temporal;
        while(!myStack.isEmpty()) {
            temporal = myStack.pop();
            response = temporal + response;
        }
        System.out.println(myStack.toString());
        return response;
    }

    public static void pushValues(Stack<Character> base, String input) {
        for(int i = 0; i < input.length(); i++) {
            base.push(input.charAt(i));
        }
    }

    public static String expandString (String times, String input) {
        int loops = Integer.valueOf(times);
        String result = "";
        for(int i = 1; i <= loops; i++) {
            result += input;
        }
        return result;
    }


    public static void main(String[] args) {
        String input = "3[abc]";
        //decodeString(input);
        System.out.println(decodeString(input));

//        String input2 = "3[abc]";
//        decodeString(input2);

    }
}
