package com.miscellaneous;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4};
        int[] res = productExceptSelf(nums);
        for (int num : res) System.out.println(num + ", ");

    }


    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] prefixProduct = new int[length];
        int[] postfixProduct = new int[length];
        int[] res = new int[length];

        prefixProduct[0] = 1;
        for (int i = 1; i < length; i++) {
            prefixProduct[i] = prefixProduct[i-1] * nums[i-1];
        }

        postfixProduct[length-1] = 1;
        for (int i = length-2; i >= 0; i--) {
            postfixProduct[i] = postfixProduct[i+1] * nums[i+1];
        }

        for (int i = 0; i < length; i++) {
            res[i] = prefixProduct[i] * postfixProduct[i];
        }

        return res;
    }
}
