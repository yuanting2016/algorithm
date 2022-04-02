package com.example.algorithm.base.easy

/**
 * @description:检查某单词是否等于两单词之和
 * @author: tingyuan
 * @date: 2022/4/2
 */
object num_1880 {

    @JvmStatic
    fun main(args: Array<String>) {
        System.out.println(isSumEqual("aaa","a","aab"))
    }

    fun isSumEqual(firstWord: String, secondWord: String, targetWord: String): Boolean {
        val a = stringToInt(firstWord)
        val b = stringToInt(secondWord)
        val c = stringToInt(targetWord)
        if (a + b == c) {
            return true
        }
        return false
    }

    fun stringToInt(str: String): Int {
        val sb = StringBuffer()
        var i = 0
        for (c in str.toCharArray()) {
            when (c) {
                'a' -> i = 0
                'b' -> i = 1
                'c' -> i = 2
                'd' -> i = 3
                'e' -> i = 4
                'f' -> i = 5
                'g' -> i = 6
                'h' -> i = 7
                'i' -> i = 8
                'j' -> i = 9
            }
            sb.append(i);
        }
        return sb.toString().toInt()
    }
}