package leetcode.java.general;


/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 */

public class BestTimeToBuyAndSellStock {


    // Kadane algoritm
    public static int maxProfit(int[] prices) {
        int diff = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            diff = Math.max(diff, prices[i] - min);
            min = Math.min(prices[i], min);

        }
        return diff;
    }

    public static void main(String[] args) {
        int[] input = {7, 1, 5, 3, 6, 4};
        int output = maxProfit(input);
        System.out.println(output);
    }
}

