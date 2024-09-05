package leetcode.java.general;


/*
https://leetcode.com/problems/sqrtx
 */

public class SqrtX {

    public static int mySqrt(int x) {
        double result = Math.sqrt(x);
        int rounded = (int) Math.floor(result);
        return rounded;
    }

    public static void main(String[] args) {
        int output = mySqrt(8);
        System.out.println(output);
    }

}
