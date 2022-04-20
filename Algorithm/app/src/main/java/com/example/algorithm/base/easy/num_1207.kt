package com.example.algorithm.base.easy

import android.os.Build
import androidx.annotation.RequiresApi

/**
 * @description:给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。

如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * @author: tingyuan
 * @date: 2022/4/19
 */
object num_1207 {
    @RequiresApi(Build.VERSION_CODES.N)
    @JvmStatic
    fun main(args: Array<String>) {
        println(uniqueOccurrences(intArrayOf(1, 2, 2, 1, 1, 3)))
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val occur: MutableMap<Int, Int> = HashMap()
        for (x in arr) {
            occur[x] = occur.getOrDefault(x, 0) + 1
        }
        val times: MutableSet<Int> = HashSet()
        for ((_, value) in occur) {
            times.add(value)
        }
        return times.size == occur.size
    }
}
