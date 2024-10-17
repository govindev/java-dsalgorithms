package com.sdesheet.blind;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        // return productExceptSelfExtraSpace(nums);
        return productExceptSelfNoExtraSpace(nums);
    }


    public int[] productExceptSelfNoExtraSpace(int[] nums) {
        int[] res = getPreProducts(nums);
        int postProduct = 1;
        for (int i = nums.length-2; i >=0; i--) {
            postProduct *= nums[i+1];
            res[i] *= postProduct;
        }
        return res;
    }

    public int[] productExceptSelfExtraSpace(int[] nums) {
        int[] preProducts = getPreProducts(nums);
        int[] postProducts = getPostProducts(nums);
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = preProducts[i] * postProducts[i];
        }
        return res;
    }

    private int[] getPreProducts(int[] nums) {
        int[] preProducts = new int[nums.length];
        preProducts[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            preProducts[i] = preProducts[i-1] * nums[i-1];
        }
        return preProducts;
    }

    private int[] getPostProducts(int[] nums) {
        int[] postProducts = new int[nums.length];
        postProducts[nums.length-1] = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            postProducts[i] = postProducts[i+1] * nums[i+1];
        }
        return postProducts;
    }
}
