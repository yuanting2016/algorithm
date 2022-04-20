package com.example.algorithm.base.easy

/**
 * @description:给你一个整数数组 digits ，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素。

你需要找出 所有 满足下述条件且 互不相同 的整数：

该整数由 digits 中的三个元素按 任意 顺序 依次连接 组成。
该整数不含 前导零
该整数是一个 偶数
例如，给定的 digits 是 [1, 2, 3] ，整数 132 和 312 满足上面列出的全部条件。

将找出的所有互不相同的整数按 递增顺序 排列，并以数组形式返回。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/finding-3-digit-even-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: tingyuan
 * @date: 2022/4/19
 */
object num_2094 {

    @JvmStatic
    fun main(args: Array<String>) {
        findEvenNumbers(intArrayOf(2, 2, 8, 8, 2)).forEach {
            println(it)
        }
//        shortestToChar("aaab", 'b').forEach {
//            println(it)
//        }
    }

    fun findEvenNumbers(digits: IntArray): IntArray {
        val res = arrayListOf<Int>()
        for (i in digits.indices) {
            for (j in digits.indices) {
                for (k in digits.indices) {
                    if (i == j || i == k || j == k) {
                        continue
                    }
                    val num = digits[i] * 100 + digits[j] * 10 + digits[k]
                    if (num >= 100 && num % 2 == 0) {
                        if (!res.contains(num)) {
                            res.add(num)
                        }
                    }
                }
            }
        }
        val realRes = res.toIntArray()
        realRes.sort()
        return realRes
    }
}
