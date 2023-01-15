package com.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 1. First do the sorting
        Arrays.sort(nums);


        // 2. Create the list
        List<List<Integer>> res = new ArrayList<>();

        for (int a = 0; a < nums.length - 3; a++) {

            if (a != 0 && nums[a-1] == nums[a]) continue;

            for (int b = a+1; b < nums.length - 2; b++) {

                if (b != a+1 && nums[b-1] == nums[b]) continue;
                int c = b+1, d = nums.length-1;

                while (c < d)  {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum > target) {
                        d--;
                    } else if (sum < target) {
                        c++;
                    } else {
                        res.add(List.of(nums[a], nums[b], nums[c], nums[d]));
                        c++;
                        while (c < d && nums[c] == nums[c-1]) c++;
                    }
                }
            }
        }

        return res;
    }
}
