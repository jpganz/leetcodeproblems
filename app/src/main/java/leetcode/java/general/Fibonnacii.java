package leetcode.java.general;


/*
https://leetcode.com/problems/fibonacci-number/description/
 */


import java.util.HashSet;
import java.util.Set;

public class Fibonnacii {


    public static int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        int previousA = 0;
        int previousB = 1;
        for(int i = 2; i <= n; i++) {
            int temporal = previousA + previousB;
            previousA = previousB;
            previousB = temporal;
        }
        return previousB;
    }



    public static void main(String[] args) {


        var output = fib(4);
        System.out.println("the output is " + output);

    }


}
