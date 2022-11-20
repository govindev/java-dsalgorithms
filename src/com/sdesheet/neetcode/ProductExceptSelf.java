package com.sdesheet.neetcode;

public class ProductExceptSelf {
    public int[] productExceptSelfWithExtraSpace(int[] nums) {
        int len = nums.length;
        // Calculate the prefix
        int[] prefix = new int[len];
        prefix[0] = 1;
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i-1]*nums[i-1];
        }

        // Calculate the postfix
        int[] postfix = new int[len];
        postfix[len-1] = 1;
        for (int i = len-2; i >= 0; i--) {
            postfix[i] = postfix[i+1] * nums[i+1];
        }

        int[] output = new int[len];
        output[0] = postfix[0];
        output[len-1] = prefix[len-1];
        for (int i = 1; i < len-1; i++) {
            output[i] = prefix[i] * postfix[i];
        }
        return output;
    }
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        // Calculate the prefix
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i-1]*nums[i-1];
        }

        int postfix = 1;
        for (int i = len-1; i >= 0; i--) {
            if (i < len-1)
                postfix *= nums[i+1];
            res[i] *= postfix;
        }
        return res;
    }
}
