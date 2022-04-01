package com.example.algorithm.base.bitoperation

/**
 * @description:编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * @author: tingyuan
 * @date: 2022/3/30
 */
object num_191 {
    @JvmStatic
    fun main(args: Array<String>) {
        System.out.println(hammingWeight(1))
    }

    fun hammingWeight(n: Int): Int {
        var count = 0
        for (i in 0..31) {
            val temp = 1 shl i
            if ((n and temp) != 0) {
                count ++
            }
        }
        return count
    }
}
