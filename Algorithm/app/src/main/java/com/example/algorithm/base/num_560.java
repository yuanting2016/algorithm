package com.example.algorithm.base;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;

/**
 * @description: 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 * @author: tingyuan
 * @date: 2022/2/25
 */
public class num_560 {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args){
       int[] nums = {1,1,1};
       System.out.println(subarraySum(nums,2));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static int subarraySum(int[] nums, int k) {
        int length = nums.length;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        int result = 0;
        int sum_0_i = 0;
        for(int i = 0; i < length; i ++) {
            sum_0_i += nums[i];
            int sum_0_j = sum_0_i -k;
            if(preSum.containsKey(sum_0_j)) {
                result += preSum.get(sum_0_j);
            }
            preSum.put(sum_0_i,preSum.getOrDefault(sum_0_i,0) + 1);
        }
        return result;
    }
}
