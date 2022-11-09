package com.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> leaders = new ArrayList<>();
        int maxRight = arr[n-1];
        leaders.add(maxRight);
        for (int i = n-2; i >= 0; i--) {
            if (arr[i] >= maxRight) {
                leaders.add(arr[i]);
                maxRight = arr[i];
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }
}
