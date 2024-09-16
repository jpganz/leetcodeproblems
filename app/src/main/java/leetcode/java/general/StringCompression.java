package leetcode.java.general;


/*
https://leetcode.com/problems/string-compression/
 */


import java.util.Arrays;

public class StringCompression {

    public static int compress(char[] chars) {
        if (chars.length == 1) return 1;
        char current = chars[0];
        int counter = 0;
        //char[] newArray = new char[chars.length];
        int position = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == current) {
                counter++;
            } else {
                chars[position] = current;
                position++;
                if (counter > 1) {
                    String counterString = String.valueOf(counter);
                    for (int j = 0; j < counterString.length(); j++) {
                        chars[position] = counterString.charAt(j);
                        position++;
                    }
                }
                //
                counter = 1;
                current = c;
            }
        }
        // we are missing to add the last one...
        chars[position] = current;
        position++;
        if (counter > 1) {
            String counterString = String.valueOf(counter);
            for (int j = 0; j < counterString.length(); j++) {
                chars[position] = counterString.charAt(j);
                position++;
            }
        }
        //
        counter = 1;

        System.out.println(Arrays.toString(chars));
        return position;
    }


    public static void main(String[] args) {
        char[] input = {'a', 'a', 'a', 'a', 'b', 'c'};
        var output = compress(input);
        System.out.println("the output is " + output);

    }


}
