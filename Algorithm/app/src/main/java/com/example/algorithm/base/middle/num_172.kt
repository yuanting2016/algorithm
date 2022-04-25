package com.example.algorithm.base.middle

/**
 * @description: 阶乘后的零
 * @author: tingyuan
 * @date: 2022/4/25
 */
object num_172 {

    @JvmStatic
    fun main(args: Array<String>) {
        println(trailingZeroes(125))
    }

    fun trailingZeroes(n: Long): Long {
        var res = 0L
        var divisor = 5
        while (divisor <= n) {
            res += n / divisor
            divisor *= 5
        }
        return res
    }
}
