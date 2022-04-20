package com.example.algorithm.base.easy

/**
 * @description:给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0
 * @author: tingyuan
 * @date: 2022/4/19
 */
object num_1304 {

    @JvmStatic
    fun main(args: Array<String>) {
        sumZero(5).forEach {
            println(it)
        }
    }
    fun sumZero(n: Int): IntArray {
        val rt = IntArray(n)
        var x = 1
        run {
            var i = 1
            while (i < rt.size) {
                rt[i - 1] = x
                rt[i] = -x
                x++
                i += 2
            }
        }
        return rt
    }
}
