package com.sdesheet.blind;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        // return productExceptSelfWithExtraSpace(nums);
        return productExceptSelfWithoutExtraSpace(nums);
    }

    public int[] productExceptSelfWithExtraSpace(int[] nums) {
        int[] beforeProducts = new int[nums.length];
        int[] afterProducts = new int[nums.length];

        beforeProducts[0] = 1;
        int product = 1;
        for (int i = 1; i < nums.length; i++) {
            product *= nums[i-1];
            beforeProducts[i] = product;
        }
        // [1, 1, 2, 6]


        product = 1;
        afterProducts[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            product *= nums[i+1];
            afterProducts[i] = product;
        }
        // [24, 12,4,1]

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = beforeProducts[i] * afterProducts[i];
        }

        return result;
    }


    public int[] productExceptSelfWithoutExtraSpace(int[] nums) {
        int[] afterProducts = new int[nums.length];


        int product = 1;
        afterProducts[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            product *= nums[i+1];
            afterProducts[i] = product;
        }
        // [24, 12,4,1]

        return getProductResult(nums, afterProducts);
    }

    public int[] getProductResult(int[] nums, int[] result) {
        int prevProduct = 1;
        for (int i = 1; i < nums.length; i++) {
            prevProduct *= nums[i-1];
            result[i] *= prevProduct;
        }
        return result;
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
