package leetcode.java.general;


/*
https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) return true;
        int toPlant = n;
        for(int i = 0; i < flowerbed.length; i++) {
            boolean isLeftAvailable = (i == 0 || flowerbed[i-1] == 0);
            boolean isRightAvailable = (i == flowerbed.length -1 || flowerbed[i+1] == 0);
            if(isLeftAvailable && isRightAvailable && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                toPlant--;
                i++;
                if(toPlant == 0) break;
            }
        }
        return toPlant == 0;
    }

    public static void main(String[] args) {
        int[] flowerbed = {0,0,0,0,0,1,0,0};
        int extraCandies = 0;
        boolean output = canPlaceFlowers(flowerbed, extraCandies);
        System.out.println(output);
    }
}

