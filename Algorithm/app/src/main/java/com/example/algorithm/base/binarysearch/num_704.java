package com.example.algorithm.base.binarysearch;

/**
 * @description: 二分查找
 * @author: tingyuan
 * @date: 2022/3/4
 */
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] > target) {
                right = mid -1;
            } else if(nums[mid]< target){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}