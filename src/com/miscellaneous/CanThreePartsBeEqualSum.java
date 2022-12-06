package com.miscellaneous;

public class CanThreePartsBeEqualSum {
    public boolean canThreePartsEqualSum(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        if (totalSum%3 != 0) return false;
        int currSum = 0, count = 0;
        for (int num : arr) {
            currSum += num;
            if (currSum == totalSum/3) { count++; currSum = 0; }
            if (count == 3) return true;
        }
        return false;
    }
}
