package com.example.algorithm.base.binarysearch

/**
 * @description:爱吃香蕉的可可
 * @author: tingyuan
 * @date: 2022/4/25
 */
object num_875 {

    @JvmStatic
    fun main(args: Array<String>) {
        println(minEatingSpeed(intArrayOf(3, 6, 7, 11), 8))
    }

    fun minEatingSpeed(piles: IntArray, H: Int): Int {
        var left = 1
        var right = 1000000000 + 1
        while (left < right) {
            val mid = left + (right - left) / 2
            if (f(piles, mid) <= H) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    // 定义：速度为 x 时，需要 f(x) 小时吃完所有香蕉
    // f(x) 随着 x 的增加单调递减
    fun f(piles: IntArray, x: Int): Int {
        var hours = 0
        for (i in piles.indices) {
            hours += piles[i] / x
            if (piles[i] % x > 0) {
                hours++
            }
        }
        return hours
    }
}
