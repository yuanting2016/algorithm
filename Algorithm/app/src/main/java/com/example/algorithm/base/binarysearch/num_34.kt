package com.example.algorithm.base.binarysearch

/**
 * @description:在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置
 * 输入：nums = [5,7,7,8,8,10], target = 8
  输出：[3,4]
 * @author: tingyuan
 * @date: 2022/3/16
 */
object num_34 {
    @JvmStatic
    fun main(args: Array<String>) {
        val testArray = intArrayOf(1)
//        var result = searchRange(testArray,0)
        var result = intArrayOf(left_bound(testArray, 1), right_bound(testArray, 1));
        result.forEachIndexed { index, i ->
            System.out.println(i)
        }
    }

    /**
     * 方法一遍历  时间复杂度o(n)
     */
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var left = 0
        var right = nums.size - 1
        val result = intArrayOf(-1,-1)
        while (left <= nums.size - 1) {
            if (nums[left] == target && result[0] == -1) {
                result[0] = left
            }
            if (nums[right] == target && result[1] == -1) {
                result[1] = right
            }
            if (result[0] != -1 && result[1] != -1 ) {
                return result
            }
            left ++
            right --
        }
        return result
    }

    /**
     * 方法二：二分查找,时间复杂度logn
     */
    fun left_bound(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        // 搜索区间为 [left, right]
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1
            }
        }
        // 检查出界情况
        return if (left >= nums.size || nums[left] != target) {
            -1
        } else left
    }

    fun right_bound(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] < target) {
                left = mid + 1
            } else if (nums[mid] > target) {
                right = mid - 1
            } else if (nums[mid] == target) {
                // 这里改成收缩左侧边界即可
                left = mid + 1
            }
        }
        // 这里改为检查 right 越界的情况，见下图
        return if (right < 0 || nums[right] != target) {
            -1
        } else right
    }

}