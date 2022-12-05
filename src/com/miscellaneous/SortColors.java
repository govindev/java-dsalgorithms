package com.miscellaneous;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = new int[] {2,0,2,1,1,0};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        int zeroCount = 0, oneCount = 0, twoCount = 0;
        for (int num : nums) {
            if (num == 0) zeroCount++;
            else if (num == 1) oneCount++;
            else twoCount++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) {
                nums[i] = 0;
                zeroCount--;
            } else if (oneCount > 0) {
                nums[i] = 1;
                oneCount--;
            } else {
                nums[i] = 2;
                twoCount--;
            }
        }
    }



    public static void sortColorsBefore(int[] nums) {
        int len = nums.length, left = 0, mid = 0, right = len-1, red = 0, white = 1, blue = 2;
        print(nums, left, mid, right);
        while (mid <= right) {
            if (nums[mid] == red) {
                nums[mid] = nums[left];
                nums[left] = red;
                left++; mid++;
                print(nums, left, mid, right);
            } else if (nums[mid] == blue) {
                nums[mid] = nums[right];
                nums[right] = blue;
                right--;
                print(nums, left, mid, right);
            } else {
                mid++;
                print(nums, left, mid, right);
            }
        }
    }
    public static void print(int[] nums, int left, int mid, int right) {
        String numsStr = "";
        for (int num : nums) {
            numsStr += num;
        }
        System.out.println("Nums: " + numsStr + ", left: " + left + ", mid: " + mid + ", right: " + right);
    }

    public void sortColorsWithMultiPasses(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for (int num : nums) {
            if (num == 0) red++;
            else if (num == 1) white++;
            else if (num == 2) blue++;
        }
        int i = 0;
        while (red > 0) {
            nums[i] = 0;
            i++;
            red--;
        }
        while (white > 0) {
            nums[i] = 1;
            i++;
            white--;
        }
        while (blue > 0) {
            nums[i] = 2;
            i++;
            blue--;
        }
    }
}
