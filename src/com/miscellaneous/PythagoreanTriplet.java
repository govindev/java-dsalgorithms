package com.miscellaneous;

import java.util.Arrays;

public class PythagoreanTriplet {
    boolean checkTripletNaive(int[] arr, int n) {
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    if ((arr[i]*arr[i] + arr[j]*arr[j]) == arr[k]*arr[k]) return true;
                    if ((arr[j]*arr[j] + arr[k]*arr[k]) == arr[i]*arr[i]) return true;
                    if ((arr[i]*arr[i] + arr[k]*arr[k]) == arr[j]*arr[j]) return true;
                }
            }
        }
        return false;
    }

    boolean checkTriplet(int[] arr, int n) {
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            arr[i] *= arr[i];
        }

        for (int i = n-1; i >= 2; i--) {
            int low = 0, high = i-1;
            while (low < high) {
                if (arr[low]+arr[high] == arr[i]) return true;
                if (arr[low]+arr[high] > arr[i]) high--;
                else low++;
            }
        }
        return false;
    }
}
