package leetcode.java.general;


/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */


import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatedCharacter {


    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> valuesPerPosition = new HashMap<>();
        int longest = 0;
        for(int i=0; i<s.length(); i++){
            Character current = s.charAt(i);
            if(!valuesPerPosition.containsKey(current)) {
                valuesPerPosition.put(current, i);
            } else {
                longest = Math.max(longest, valuesPerPosition.keySet().size());
                int initial = valuesPerPosition.get(current);
                //if I want to store them I can loop from that position +1 until the current, if not, I just make the math

                valuesPerPosition = new HashMap<>();
                valuesPerPosition.put(current, i);
                for(int j=initial+1; j<i; j++) {
                    System.out.println(" in the inner loop " + valuesPerPosition.keySet());
                    current = s.charAt(j);
                    valuesPerPosition.put(current, j);
                }
            }
            longest = Math.max(longest, valuesPerPosition.keySet().size());
            System.out.println(valuesPerPosition.keySet());
        }
        return  longest;

    }

    public static int lengthOfLongestSubstring2(String s) {
        HashSet<Character> values = new HashSet<>();
        int longest = 0;
        for(int i=0; i<s.length(); i++){
            Character current = s.charAt(i);
            if(!values.contains(current)) {
                values.add(current);
            } else {
                longest = Math.max(longest, values.size());
                values = new HashSet<>();
                values.add(current);
                int counter = i - 1;
                Character newCurrent = null;
                while(counter > 0 && newCurrent != current){
                    System.out.println(values);
                    newCurrent = s.charAt(counter);
                    values.add(newCurrent);
                    counter --;
                }

            }

           longest = Math.max(longest, values.size());
           System.out.println(values);
        }
        return  longest;

    }


    public static void main(String[] args) {
        int output = lengthOfLongestSubstring("dvdf");
        System.out.println(output);

    }


}
