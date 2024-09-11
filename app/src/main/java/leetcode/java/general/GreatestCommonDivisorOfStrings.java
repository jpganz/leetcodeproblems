package leetcode.java.general;


/*
https://leetcode.com/problems/greatest-common-divisor-of-strings/description
 */

import java.util.*;

public class GreatestCommonDivisorOfStrings {

// this code is for the LOWEST common divisor possible
//    public static String gcdOfStrings(String str1, String str2) {
//
//        String minCommon = findSmallestUnrepeatedString(str2);
//        System.out.println(" the min common is " + minCommon);
//        int length = str1.length();
//
//        List<Integer> possibleDivisors = new ArrayList<>();
//        for(int i = minCommon.length(); i <= str1.length(); i++) {
//            if(length % i == 0) {
//                possibleDivisors.add(length / i);
//            }
//        }
//        System.out.println("The divisors now are " + possibleDivisors);
//
//        boolean isRepeated = false;
//        for (Integer possible : possibleDivisors) {
//            String expanded = minCommon.repeat(possible);
//            if(str1.equals(expanded)) {
//                isRepeated = true;
//                break;
//            }
//        }
//
//        return (isRepeated) ? minCommon : "";
//    }
//
//    private static String findSmallestUnrepeatedString(String input) {
//        List<Integer> possibleDivisors = new ArrayList<>();
//        int length = input.length();
//        for (int i = 1; i <= input.length(); i++) {
//            if (length % i == 0) {
//                possibleDivisors.add(i);
//            }
//        }
//
//        String min = "";
//        for(Integer possible: possibleDivisors) {
//            int multiples = length / possible;
//            String repeated = input.substring(0, possible).repeat(multiples);
//            if(repeated.equals(input)) {
//                min = input.substring(0, possible);
//                break;
//            }
//        }
//        return min;
//    }

    public static String gcdOfStrings(String str1, String str2) {
        // so, if we have abcabc and abc , then str1+ str2 == str2+str1
        // if thats true, then str1 % str2 = 0 and str1 / str2 = length of substring
        if ((str1 + str2).equals(str2 + str1)) {
            int lengthGdc = helperGdc(str1.length(), str2.length());
            return str2.substring(0, lengthGdc);
        } else {
            return "";
        }
    }

    // using Euclidian
    private static int helperGdc(int val1, int val2) {
        int remainder =  val1 % val2;
        if (remainder == 0) {
            return val2;
        }
        return helperGdc(val2, remainder);
    }

    public static void main(String[] args) {
       var output = gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX");
       System.out.println("the output is " + output);
       var anotherOutput = helper(1701, 3768);
       System.out.println(anotherOutput);
    }
}

