package leetcode.java.general;


/*
https://leetcode.com/problems/rotated-digits/description/
 */

public class ReverseInteger {



    // 1
    // 2
    // 3
    public static int reverse(int n) {
        int load = (n < 0) ? -1 : 1;
        n = Math.abs(n);
        int multiplier  = 10;
        Long output = 0L;
        while(n > 0) {
            output = (output * multiplier) + (n % 10);
            n = n/10;
       }
        output = output * load;
        if(output < Integer.MIN_VALUE || output > Integer.MAX_VALUE) return 0;
        return Integer.valueOf(Math.toIntExact(output));
    }



    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}

