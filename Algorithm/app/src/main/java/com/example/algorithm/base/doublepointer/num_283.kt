package com.example.algorithm.base.doublepointer

/**
 * @description:给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * @author: tingyuan
 * @date: 2022/3/10
 */
object num_283 {

    @JvmStatic
    fun main(args: Array<String>) {
        val testArray = intArrayOf(0, 1, 0)
        val resut = moveZeroes(testArray)
        resut.forEachIndexed { index, i ->
            System.out.println(i)
        }
    }

    /**
     * 计算出 0 的个数，然后每个0前面的数字依次往前移动
     */
    fun moveZeroes(nums: IntArray): IntArray {
        var zeroesCount = 0
        nums.forEachIndexed { index, temp ->
            if (temp == 0) {
                zeroesCount ++
            } else {
                nums[index - zeroesCount] = temp
            }
        }
        nums.forEachIndexed { index, i ->
            if (index >= nums.size - zeroesCount) {
                nums[index] = 0
            }
        }
        return nums
    }
}
