package com.example.algorithm.base.doublepointer

/**
 * @description:编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * @author: tingyuan
 * @date: 2022/3/14
 */
object num_344 {
    @JvmStatic
    fun main(args: Array<String>) {
        val testArray = charArrayOf('h', '3', '3', 'w')
        reverseString(testArray)
        testArray.forEachIndexed { index, i ->
            System.out.println(i)
        }
    }
    private fun reverseString(s: CharArray) {
        var left = 0
        var right = s.size - 1
        while (left <= right) {
            val leftChar = s[left]
            s[left] = s[right]
            s[right] = leftChar
            left ++
            right --
        }
    }
}
