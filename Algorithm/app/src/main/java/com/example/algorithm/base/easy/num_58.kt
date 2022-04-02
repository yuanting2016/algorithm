package com.example.algorithm.base.easy

/**
 * @description:给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * @author: tingyuan
 * @date: 2022/4/2
 */
object num_58 {

    @JvmStatic
    fun main(args: Array<String>) {
        System.out.println(lengthOfLastWord(" luffy is still joyboy"))
    }
    fun lengthOfLastWord(s: String): Int {
        val charNums = s.toCharArray()
        var count = 0
        var isOnlyEmpty = true
        for (i in charNums.size - 1 downTo 0) {
            if (charNums[i] != ' ') {
                isOnlyEmpty = false
            }
            if (!isOnlyEmpty && charNums[i] != ' ') {
                count ++
            }
            if (!isOnlyEmpty && charNums[i] == ' ') {
                break
            }
        }
        return count
    }
}
