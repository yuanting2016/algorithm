package com.example.algorithm.base.danamicplanning

import java.util.*

/**
 * @description:
 * @author: tingyuan
 * @date: 2022/4/14
 */
object num_198 {

    // 备忘录
    lateinit var memo: IntArray
    fun rob(nums: IntArray): Int {
        memo = IntArray(nums.size)
        Arrays.fill(memo,-1)
        return dp(nums, 0)
    }

    fun dp(nums: IntArray, start: Int): Int{
        if (start >= nums.size) {
            return 0
        }
        if (memo[start] != -1) {
            return memo[start]
        }
        val res = dp(nums, start + 1).coerceAtLeast(nums[start] + dp(nums, start + 2))
        // 记入备忘录
        memo[start] = res
        return res
    }
}