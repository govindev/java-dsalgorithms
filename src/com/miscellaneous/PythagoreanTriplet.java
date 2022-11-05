package com.miscellaneous;

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
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i]*arr[i];
        }
        Arrays.sort(arr);
        for (int i = n-1; i >=2; i--) {
            int start = 0, end = i-1;
            while (start < end) {
                if (arr[i] == arr[start]+arr[end]) return true;
                if (arr[start]+arr[end] > arr[i]) end--;
                else start++;
            }
        }
        return false;
    }
}
