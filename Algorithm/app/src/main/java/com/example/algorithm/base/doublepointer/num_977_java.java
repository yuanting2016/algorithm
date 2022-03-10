package com.example.algorithm.base.doublepointer;

/**
 * @description:
 * @author: tingyuan
 * @date: 2022/3/9
 */
public class num_977_java {
    public static void main(String[] args) {
        int[] test = {-4, -1, 0, 3, 10};
        int[] re = sortedSquares(test);
        for (int i = 0; i < re.length; i++) {
            System.out.println(re[i]);
        }
    }

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int negative = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                ans[index] = nums[j] * nums[j];
                ++j;
            } else if (j == n) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else {
                ans[index] = nums[j] * nums[j];
                ++j;
            }
            ++index;
        }

        return ans;
    }
}
