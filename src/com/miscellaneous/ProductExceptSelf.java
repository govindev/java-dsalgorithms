package com.miscellaneous;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4};
        int[] res = productExceptSelf(nums);
        for (int num : res) System.out.println(num + ", ");

    }

    public static int[] productExceptSelf(int[] nums) {
        // Most optimum approach

        int[] res = new int[nums.length];

        // Store prefix products in the res
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }

        // Calculate the postfix products and parallaly compute the prefix * postfix
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = postfix * res[i];
            postfix *= nums[i];
        }

        return res;
    }

    public int[] productExceptSelfExtraSpace(int[] nums) {
        // Extra space is required
        int len = nums.length;
        int[] prefix = new int[len];
        int[] postfix = new int[len];
        int[] res = new int[len];

        prefix[0] = 1;
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        postfix[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            postfix[i] = postfix[i+1] * nums[i+1];
        }

        for (int i = 0; i < len; i++) {
            res[i] = prefix[i] * postfix[i];
        }
        return res;
    }
    public int[] productExceptSelfCasting(int[] nums) {
        // Type casting is required
        int zeroCount = 0;
        long product = 1;
        int[] res = new int[nums.length];
        for (int num : nums) {
            if (num == 0) zeroCount++;
            else product *= num;
            if (zeroCount > 1) return res;
        }
        if (zeroCount == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    res[i] = (int) product;
                    return res;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = (int) (product / nums[i]);
        }
        return res;
    }
}
