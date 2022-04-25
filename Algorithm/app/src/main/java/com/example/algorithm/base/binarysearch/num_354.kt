package com.example.algorithm.base.binarysearch

import java.util.*
import kotlin.Comparator

/**
 * @description:俄罗斯套娃信封问题
 * @author: tingyuan
 * @date: 2022/4/25
 */
object num_354 {

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            maxEnvelopes(
                arrayOf(
                    intArrayOf(5, 4),
                    intArrayOf(6, 4),
                    intArrayOf(6, 7),
                    intArrayOf(2, 3)
                )
            )
        )
    }

    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        val n = envelopes.size
        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(
            envelopes,
            object : Comparator<IntArray> {
                override fun compare(a: IntArray, b: IntArray): Int {
                    return if (a[0] == b[0]) b[1] - a[1] else a[0] - b[0]
                }
            }
        )
        // 对高度数组寻找 LIS
        val height = IntArray(n)
        for (i in 0 until n) {
            height[i] = envelopes[i][1]
        }
        return lengthOfLIS(height)
    }

    /* 返回 nums 中 LIS 的长度 */
    fun lengthOfLIS(nums: IntArray): Int {
        var piles = 0
        val n = nums.size
        val top = IntArray(n)
        for (i in 0 until n) {
            val poker = nums[i]
            var left = 0
            var right = piles
            // 二分查找插入位置
            while (left < right) {
                val mid = (left + right) / 2
                if (top[mid] >= poker) {
                    right = mid
                } else {
                    left = mid + 1
                }
            }
            if (left == piles) {
                piles++
            }
            top[left] = poker
        }
        return piles
    }
}
