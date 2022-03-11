package com.example.algorithm.base

/**
 * @description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

问总共有多少条不同的路径？
 * @author: tingyuan
 * @date: 2022/3/11
 */
object num_62 {
    @JvmStatic
    fun main(args: Array<String>) {
        System.out.println(uniquePaths(10, 10))
    }

    /**
     * 使用这种方式会内存溢出
     */
    fun uniquePaths1(m: Int, n: Int): Int {
        var top = 1.00
        var bottom = 1.00
        for (i in 1 until m) {
            bottom *= i
        }
        for (i in 0 until m - 1) {
            val temp = m + n - 2 - i
            top *= temp
        }
        return (top / bottom).toInt()
    }

    fun uniquePaths(m: Int, n: Int): Int {
        var ans = 1L
        var top = n
        for (i in 1..m - 1) {
            ans = ans * top / i
            top ++
        }
        return ans.toInt()
    }
}
