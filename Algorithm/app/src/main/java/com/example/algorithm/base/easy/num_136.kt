package com.example.algorithm.base.easy

/**
 * @description:给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @author: tingyuan
 * @date: 2022/4/2
 */
object num_136 {

    @JvmStatic
    fun main(args: Array<String>) {
        System.out.println(singleNumber(intArrayOf(2, 2 ,1)))
    }

    fun singleNumber(nums: IntArray): Int {
        var res = 0
        for (n in nums) {
            res = res xor n
        }
        return res
    }
}