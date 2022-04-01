package com.example.algorithm.base.bitoperation

/**
 * @description:颠倒给定的 32 位无符号整数的二进制位。
 * @author: tingyuan
 * @date: 2022/4/1
 */
object num_190 {
    @JvmStatic
    fun main(args: Array<String>) {
        System.out.println(reverseBits(1))
    }

    fun reverseBits(n: Int): Int {
        var a = 0
        for (i in 0..31) {
            a += (1 and (n shr i) shl 31 - i)
        }
        return a
    }
}