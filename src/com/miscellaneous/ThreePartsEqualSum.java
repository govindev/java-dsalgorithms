package com.miscellaneous;

public class ThreePartsEqualSum {
    public boolean canThreePartsEqualSum(int[] arr) {
        int leftSum = 0, rightSum = 0, totalSum = 0;
        for (int num : arr) totalSum += num;
        if (totalSum%3 != 0) return false;
        int part = totalSum / 3;
        int curr = 0, count = 0;
        for (int num : arr) {
            curr += num;
            if (curr == part) {
                count++; curr = 0;
                if (count == 3) return true;
            }
        }
        return false;
    }
}
