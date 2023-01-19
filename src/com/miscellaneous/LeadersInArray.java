package com.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        int rightMax = Integer.MIN_VALUE;
        ArrayList<Integer> leaders = new ArrayList<>();
        for (int i = n-1; i >= 0; i--) {
            if (arr[i] >= rightMax) {
                leaders.add(arr[i]);
            }
            rightMax = Math.max(rightMax, arr[i]);
        }
        Collections.reverse(leaders);
        return leaders;
    }
}
