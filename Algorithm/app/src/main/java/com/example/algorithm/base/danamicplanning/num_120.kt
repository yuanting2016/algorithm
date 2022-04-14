package com.example.algorithm.base.danamicplanning

import java.util.*

/**
 * @description:给定一个三角形 triangle ，找出自顶向下的最小路径和。

每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/triangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: tingyuan
 * @date: 2022/4/14
 */
class num_120 {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val n = triangle.size
        // 定义：走到第 i 行第 j 个元素的最小路径和是 dp[i][j]
        val dp = Array(n) { IntArray(n) }
        for (i in dp.indices) {
            // 因为求最小值，所以全都初始化为极大值
            Arrays.fill(dp[i], Int.MAX_VALUE)
        }
        // base case
        dp[0][0] = triangle[0][0]
        // 进行状态转移
        for (i in 1 until dp.size) {
            val row = triangle[i]
            for (j in row.indices) {
                // 状态转移方程
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + row[j]
                } else {
                    dp[i][j] = dp[i - 1][j] + row[j]
                }
            }
        }
        // 找出落到最后一层的最小路径和
        var res = Int.MAX_VALUE
        for (j in 0 until dp[n - 1].size) {
            res = Math.min(res, dp[n - 1][j])
        }
        return res
    }
}