package com.sdesheet.striver;

import java.util.Arrays;

public class MinimumPlatforms {
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int minPlatformsReq = 0;
        int platforms = 1, i = 1, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
            } else {
                platforms--;
                j++;
            }
            minPlatformsReq = Math.max(platforms, minPlatformsReq);
        }

        return minPlatformsReq;
    }
}
