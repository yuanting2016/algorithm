package com.example.algorithm.base.doublepointer

/**
 * @description:给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。

以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。

你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * @author: tingyuan
 * @date: 2022/3/14
 */
object num_167 {
    @JvmStatic
    fun main(args: Array<String>) {
        val testArray = intArrayOf(2, 3,4)
        var res = twoSum(testArray, 6)
        res.forEachIndexed { index, i ->
            System.out.println(i)
        }
    }
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val res = IntArray(2)
        var left = 0
        var right = numbers.size - 1

        while (left < numbers.size && right > 0) {
            if (numbers[left] + numbers[right] == target) {
                res[0] = left + 1
                res[1] = right + 1
                break
            } else if (numbers[left] + numbers[right] < target) {
                left ++
            } else if (numbers[left] + numbers[right] > target) {
                right --
            }
        }
        return res
    }
}
