package com.example.algorithm.base.easy

/**
 * @description:
 * @author: tingyuan
 * @date: 2022/4/21
 */
object num_interview_1716 {
    @JvmStatic
    fun main(args: Array<String>) {
        println(massage(intArrayOf(1, 2, 3)))
    }

    /**
     * 动态规划的思想
     */
    fun massage(nums: IntArray): Int {
        // 加上第i个数的最大值
        var a = nums[0]
        // 不加第i个数的最大值
        var b = 0
        for (i in nums.indices) {
            val temp = a
            a = b + nums[i]
            b = Math.max(b, temp)
        }
        return Math.max(a, b)
    }
}
