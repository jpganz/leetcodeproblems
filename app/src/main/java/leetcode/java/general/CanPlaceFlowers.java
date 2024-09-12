package leetcode.java.general;


/*
https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int[] extendedBed = new int[flowerbed.length + 2];
        System.arraycopy(flowerbed, 0, extendedBed, 1, flowerbed.length);
        int toPlant = n;
        for(int i = 1; i <= flowerbed.length; i++) {
            if(extendedBed[i] == 0 && extendedBed[i-1] == 0 && extendedBed[i+1] == 0) {
                extendedBed[i] = 1;
                toPlant--;
            }
        }
        return toPlant <= 0;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1,0,0};
        int extraCandies = 2;
        boolean output = canPlaceFlowers(flowerbed, extraCandies);
        System.out.println(output);
    }
}

