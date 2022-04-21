package com.example.algorithm.base.easy

/**
 * @description:给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。

请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shuffle-the-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: tingyuan
 * @date: 2022/4/21
 */
object num_1470 {

    @JvmStatic
    fun main(args: Array<String>) {
        shuffle(intArrayOf(2, 5, 1, 3, 4, 7), 3).forEach {
            println(it)
        }
    }

    fun shuffle(nums: IntArray, n: Int): IntArray {
        val ans = IntArray(n shl 1)
        var index = 0
        for (i in 0 until n) {
            ans[index++] = nums[i]
            ans[index++] = nums[n + i]
        }
        return ans
    }
}
