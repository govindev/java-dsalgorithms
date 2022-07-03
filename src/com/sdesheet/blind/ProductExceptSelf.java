package com.sdesheet.blind;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        // Without using the division operator
        // Without using the extra space
        int n = nums.length;
        int[] res = new int[n];
        // Prefix calculation
        res[0] = nums[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1]*nums[i];
        }
        res[n-1] = res[n-2];
        int postfix = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            res[i] = postfix*((i==0) ? 1 : res[i-1]);
            postfix *= nums[i];
        }
        return res;
    }
    public int[] productExceptSelfUsingExtraSpace(int[] nums) {
        // Without using the division operator
        // Using the extra space
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1]*nums[i];
        }
        int[] postfix = new int[n];
        postfix[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            postfix[i] = postfix[i+1]*nums[i];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = ((i == 0) ? 1 : prefix[i-1]) * ((i == n-1) ? 1 : postfix[i+1]);
        }
        return res;
    }

    public int[] productExceptSelfUsingDivision(int[] nums) {
        int product = 1, count = 0, zeroInd = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
                zeroInd = i;
            }
            else product *= nums[i];
        }
        int[] res = new int[nums.length];
        if (count == 0)
            for (int i = 0; i < nums.length; i++) {
                res[i] = product / nums[i];
            }
        if (count == 1) res[zeroInd] = product;
        return res;
    }
}
