package com.example.algorithm.base.doublepointer

/**
 * @description:给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * @author: tingyuan
 * @date: 2022/3/10
 */
object num_189 {
    @JvmStatic
    fun main(args: Array<String>) {
        val testArray = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val resut = rotate(testArray,3)
        resut.forEachIndexed { index, i ->
            System.out.println(i)
        }
    }

    fun rotate(nums: IntArray, k: Int): IntArray {
        val res = IntArray(nums.size)
        nums.forEachIndexed { index, i ->
            res[index] = i
        }
        var step = k % nums.size
        if (step == 0) {
            return nums
        }
        res.forEachIndexed { index, i ->
            var realIndex = (index + step) % res.size
            nums[realIndex] = i
        }
        return nums
    }
}
