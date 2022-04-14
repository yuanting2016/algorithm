package com.example.algorithm.base.danamicplanning

/**
 * @description:假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @author: tingyuan
 * @date: 2022/4/14
 */
object num_70 {

    // 备忘录
    lateinit var memo: IntArray

    fun climbStairs(n: Int): Int {
        memo = IntArray(n + 1)
        return dp(n)
    }

    fun dp(n: Int): Int {
        if (n <= 2) {
            return n
        }
        if (memo[n] > 0) {
            return memo[n]
        }
        memo[n] = dp(n - 1) + dp(n - 2)
        return memo[n]
    }
}
