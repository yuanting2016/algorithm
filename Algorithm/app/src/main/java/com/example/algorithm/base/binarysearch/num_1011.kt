package com.example.algorithm.base.binarysearch

/**
 * @description:传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。

传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。

返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 * @author: tingyuan
 * @date: 2022/3/16
 */
object num_1011 {
    @JvmStatic
    fun main(args: Array<String>) {
        val testArray = intArrayOf(1,2,3,4,5,6,7,8,9,10)
        val days = 5
        System.out.println(shipWithinDays(testArray,days))
    }
    fun shipWithinDays(weights: IntArray, days: Int): Int {
        return 0
    }
}
