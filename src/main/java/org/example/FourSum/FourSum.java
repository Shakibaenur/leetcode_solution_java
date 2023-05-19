package org.example.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // skip duplicates
            }

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue; // skip duplicates
                }

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++; // skip duplicates
                        }
                        left++;

                        while (left < right && nums[right] == nums[right - 1]) {
                            right--; // skip duplicates
                        }
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        int target = -294967296;
        List<List<Integer>> result = fourSum.fourSum(nums, target);
        System.out.println(result);
    }
}
