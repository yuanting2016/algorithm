package com.example.algorithm.base.easy

/**
 * @description:给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。

初始化 A 和 B 的元素数量分别为 m 和 n。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sorted-merge-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: tingyuan
 * @date: 2022/4/20
 */
object num_interview_1 {
    @JvmStatic
    fun main(args: Array<String>) {
        val a = intArrayOf(1, 2, 3, 0, 0, 0)
        val b = intArrayOf(2, 5, 6)
        merge(a, 3, b, 3)
        a.forEach {
            println(it)
        }
    }

    /**
     * 使用双指针
     */
    fun merge(A: IntArray, m: Int, B: IntArray, n: Int) {
        var pa = 0
        var pb = 0
        var cur: Int
        val sorted = IntArray(m + n)
        while (pa < m || pb < n) {
            cur = when {
                pa == m -> {
                    B[pb++]
                }
                pb == n -> {
                    A[pa++]
                }
                A[pa] < B[pb] -> {
                    A[pa++]
                }
                else -> {
                    B[pb++]
                }
            }
            sorted[pa + pb - 1] = cur
        }
        for (i in 0 until m + n) {
            A[i] = sorted[i]
        }
    }
}
