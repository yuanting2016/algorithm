package com.example.algorithm.base.binarysearch

import java.util.*

/**
 * @description:给定一个含有 n 个正整数的数组和一个正整数 target 。

找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: tingyuan
 * @date: 2022/3/28
 */
object num_209 {
    @JvmStatic
    fun main(args: Array<String>) {
        println(minSubArrayLen1(7, intArrayOf(1, 1, 1, 1, 7)))
    }
    // 前缀和+二分查找
    fun minSubArrayLen(s: Int, nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var res = Int.MAX_VALUE
        val sums = IntArray(nums.size + 1)
        sums[0] = 0
        for (i in 1..nums.size) {
            sums[i] = sums[i - 1] + nums[i - 1]
        }
        for (i in 1..nums.size) {
            val target = s + sums[i - 1]
            var bound = Arrays.binarySearch(sums, target)
            if (bound < 0) {
                bound = - bound - 1
            }
            if (bound <= nums.size) {
                res = res.coerceAtMost(bound - (i - 1))
            }
        }
        if (res == Int.MAX_VALUE) {
            res = 0
        }
        return res
    }
    // 滑动窗口
    fun minSubArrayLen1(s: Int, nums: IntArray): Int {
        var i = 0
        var sum = 0
        var len = 0
        for (j in nums.indices) {
            sum += nums[j]
            while (sum >= s) {
                len = if (len == 0) j - i + 1 else len.coerceAtMost(j - i + 1)
                sum -= nums[i++]
            }
        }
        return len
    }
}
