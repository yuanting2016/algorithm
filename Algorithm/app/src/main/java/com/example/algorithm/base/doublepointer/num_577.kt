package com.example.algorithm.base.doublepointer

/**
 * @description:给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * @author: tingyuan
 * @date: 2022/3/15
 */
object num_577 {
    @JvmStatic
    fun main(args: Array<String>) {
        val testArray = "hehe hehe hehe hehe"
        reverseWords(testArray).forEachIndexed { index, i ->
            System.out.println(i)
        }
    }
    private fun reverseWords(s: String): String {
        val wordList = s.split(' ')
        val result = StringBuilder()
        wordList.forEachIndexed { index, s ->
            result.append(reverseCharArray(s.toCharArray()))
            if (index != wordList.size - 1) {
                result.append(' ')
            }
        }
        return result.toString()
    }

    private fun reverseCharArray(s: CharArray): CharArray {
        var left = 0
        var right = s.size - 1
        while (left <= right) {
            val leftChar = s[left]
            s[left] = s[right]
            s[right] = leftChar
            left ++
            right --
        }
        return s
    }
}
