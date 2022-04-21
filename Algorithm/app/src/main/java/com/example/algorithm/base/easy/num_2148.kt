package com.example.algorithm.base.easy

/**
 * @description:给你一个整数数组 nums ，统计并返回在 nums 中同时至少具有一个严格较小元素和一个严格较大元素的元素数目。
 * @author: tingyuan
 * @date: 2022/4/21
 */
object num_2148 {

    @JvmStatic
    fun main(args: Array<String>) {
        println(countElements(intArrayOf(1, 2, 3)))
    }

    fun countElements(nums: IntArray): Int {
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        if (nums.size <= 2) {
            return 0
        }
        nums.forEach {
            if (min >= it) {
                min = it
            }
            if (max <= it) {
                max = it
            }
        }

        var res = 0
        nums.forEach {
            if (it in (min + 1) until max) {
                res++
            }
        }
        return res
    }
}
