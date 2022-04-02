package com.example.algorithm.base.easy

/**
 * @description:给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author: tingyuan
 * @date: 2022/4/2
 */
object num_53 {

    @JvmStatic
    fun main(args: Array<String>) {
        System.out.println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    }

    fun maxSubArray(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val lastSum = mutableListOf<Int>()
        lastSum.add(nums[0])
        for (i in 1 until nums.size) {
            lastSum.add(nums[i].coerceAtLeast(nums[i] + lastSum[i - 1]))
        }
        var count = Integer.MIN_VALUE
        for (element in lastSum) {
            count = count.coerceAtLeast(element)
        }
        return count
    }
}
