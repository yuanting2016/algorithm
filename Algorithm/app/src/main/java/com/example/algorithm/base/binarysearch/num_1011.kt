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
        //每趟装载能力最小值
        var left = 0
        //每趟装载能力最大值
        var right = 1
        for (i in weights) {
            left = Math.max(left,i)
            right += i
        }
        //二分查找，再进行枚举
        while (left < right) {
            val mid = left + (right - left) / 2
            if (f(weights,mid) <= days) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    // 定义：当运载能力为 x 时，需要 f(x) 天运完所有货物
    // f(x) 随着 x 的增加单调递减
    fun f(weights: IntArray, x: Int): Int {
        var days = 0
        var i = 0
        while (i < weights.size) {
            // 尽可能多装货物
            var cap = x
            while (i < weights.size) {
                cap -= if (cap < weights[i]) break else weights[i]
                i++
            }
            days++
        }
        return days
    }
}
