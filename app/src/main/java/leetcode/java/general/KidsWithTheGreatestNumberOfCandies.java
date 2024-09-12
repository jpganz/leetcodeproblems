package leetcode.java.general;


/*
https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description
 */

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxNumberOfCandies = candies[0];
        for(int i=0; i<candies.length; i++) {
            maxNumberOfCandies = Math.max(maxNumberOfCandies, candies[i]);
        }
        List<Boolean> result = new ArrayList<>();
        for(int i=0; i<candies.length; i++) {
            Boolean greatest = (candies[i] + extraCandies >= maxNumberOfCandies);
            result.add(greatest);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        List<Boolean> output = kidsWithCandies(candies, extraCandies);
        System.out.println(output);
    }
}

