package com.gfg.dsalgo.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SquareRoot {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the nubmer : ");
        int x = Integer.parseInt(br.readLine());
        System.out.println("Square root of the number is : " + sqrtNaive(x));
    }

    private static int sqrtNaive(int x) {
        int s = 1;
        while (s*s <= x) {
            s++;
        }
        return (s-1);
    }

    private static int sqrt(int x) {
        if (x <= 1) return x;
        int left = 1, right = x, ans = -1;
        while(left <= right) {
            int mid = (left+right)/2;
            if (mid == x/mid) return mid;
            else if(mid > x/mid) right = mid-1;
            else {left = mid+1;ans = mid;}
        }
        return ans;
    }
}
