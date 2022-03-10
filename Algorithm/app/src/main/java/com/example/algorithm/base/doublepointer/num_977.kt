package com.example.algorithm.base.doublepointer

/**
 * @description: 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * @author: tingyuan
 * @date: 2022/3/9
 */
object num_977 {

    @JvmStatic
    fun main(args: Array<String>) {
        val testArray = intArrayOf(-4, -1, 0, 3, 10)
        val resut = sortedSquares(testArray)
        resut.forEachIndexed { index, i ->
            System.out.println(i)
        }
    }

    fun sortedSquares(nums: IntArray): IntArray {
        if (nums.isEmpty()) {
            return IntArray(0)
        }
        // find the first >0 point
        var demarcationPointIndex = -1
        for (i in nums.indices) {
            if (nums[i] < 0) {
                demarcationPointIndex = i
            } else {
                break
            }
        }
        // create a length== n array
        val res = IntArray(nums.size)
        // use left and right to compare nums 使用两个指针去对比左右两边的数的大小
        var right = demarcationPointIndex + 1
        var left = demarcationPointIndex
        var resIndex = 0
        while (left >= 0 || right < nums.size) {
            if (left < 0) {
                res[resIndex] = nums[right] * nums[right]
                ++right
            } else if (right == nums.size) {
                res[resIndex] = nums[left] * nums[left]
                --left
            } else if (nums[right] * nums[right] > nums[left] * nums[left]) {
                res[resIndex] = nums[left] * nums[left]
                --left
            } else {
                res[resIndex] = nums[right] * nums[right]
                ++right
            }
            ++resIndex
        }
        return res
    }
}
