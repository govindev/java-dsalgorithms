package com.sdesheet.blind;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        // return productExceptSelfWithExtraSpace(nums);
        return productExceptSelfWithoutExtraSpace(nums);
    }

    public int[] productExceptSelfWithoutExtraSpace(int[] nums) {
        int[] after = new int[nums.length];

        after[nums.length - 1] = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            after[i] = nums[i+1] * after[i+1];
        }

        int before = 1;
        for (int i = 1; i < after.length; i++) {
            before *= nums[i-1];

            after[i] *= before;
        }
        return after;
    }

    public int[] productExceptSelfWithExtraSpace(int[] nums) {
        int[] before = new int[nums.length];
        int[] after = new int[nums.length];

        before[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            before[i] = nums[i-1] * before[i-1];
        }

        // after[nums.length-1] = 1;
        // for (int i = nums.length-2; i >= 0; i--) {
        //     after[i] = nums[i+1] * after[i+1];
        // }


        int nextElm = nums[nums.length-1];
        nums[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int product = nextElm * nums[i+1];
            nextElm = nums[i];
            nums[i] = product;
        }

        // for (int i = 0; i < nums.length; i++) {
        //     nums[i] = before[i] * after[i];
        // }

        for (int i = 0; i < nums.length; i++) {
            nums[i] *= before[i];
        }

        return nums;
    }
}
