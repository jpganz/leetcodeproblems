package leetcode.java.general;

/*
https://leetcode.com/problems/balanced-binary-tree/description/
 */
public class LongestPalindromicSubstring {

    // we can do a very ugly solution with two loops
    // if we have aabbaa then we will do a loop on the first a
    // to a, to b, to b to a and then finally to a
    // later second a starts and so on...
    // second solution: we can iterate on s[1], we have two options of palindromes,
    // even and odd length-words, so, abba or abcba, which means I can iterate looking for both cases
    // if I find s[-1] = s[s] || s[-1] = s[+1] then its a palindrome
    // after a find the minimum palindrome, then I expand it using a different function
    // which will do s[-1 + n] and s[+1 +n] until they are no longer equal
    // so, I find bb or bcb  and then iterate next until they are no longer equal or array is empty
    public static String longestPalindrome(String s) {
        // so, how do I find a palindrome string? :) thats a weird one
        if (s.length() == 0 || s.length() == 1) return s;

        char[] input = s.toCharArray();
        String longestPalindrome = String.valueOf(s.charAt(0));
        String temporalOdd = longestPalindrome;
        String temporalEven = longestPalindrome;
        String longesInteration = longestPalindrome;
        for (int i = 0; i < input.length - 1; i++) {
            //first case
            if (s.charAt(i) == s.charAt(i + 1)) {
                if (i > 0 && s.charAt(i - 1) == s.charAt(i)) {
                    temporalOdd = expandedPalindrome(input, i-1, i+1);
                }
                //second case case when we have aaa pattern
                temporalEven = expandedPalindrome(input, i, i+1);

            } else if( i > 0 && s.charAt(i-1) == s.charAt(i+1)){
                // second case when we have aba pattern
                    temporalOdd = expandedPalindrome(input, i-1, i+1);
                    temporalEven = "";
            }
            longesInteration = (temporalOdd.length() > temporalEven.length()) ? temporalOdd : temporalEven;
            longestPalindrome = (longesInteration.length() > longestPalindrome.length()) ? longesInteration : longestPalindrome;
        }
        return longestPalindrome;
    }

    private static String expandedPalindrome(char[] input, int leftIndex, int rightIndex) {
        while (leftIndex >= 0 && rightIndex < input.length && input[leftIndex] == input[rightIndex]) {
            leftIndex--;
            rightIndex++;
        }
        return new String(input, leftIndex + 1, rightIndex - leftIndex - 1);
    }


    public static void main(String args[]) {
        String input = "babad";
        System.out.println("the output is " + longestPalindrome(input));

    }

    private static void fillTree(int leftValue, int rightValue, TreeNode parentNode) {
        parentNode.left = new TreeNode(leftValue);
        parentNode.right = new TreeNode(rightValue);
    }
}