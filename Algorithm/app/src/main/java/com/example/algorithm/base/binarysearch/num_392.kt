package com.example.algorithm.base.binarysearch

/**
 * @description:
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * @author: tingyuan
 * @date: 2022/3/16
 */
object num_392 {
    @JvmStatic
    fun main(args: Array<String>) {
        val testArray = "abc"
        val string = "ahbgdc"
        System.out.println(isSubsequence(string,testArray))
    }
    fun isSubsequence(s: String, t: String): Boolean {
        var sleft = 0
        var tleft = 0
        while (tleft < t.length && sleft < s.length) {
            if (s[sleft] == t[tleft]) {
                sleft ++
            }
            tleft ++
        }
        return sleft == s.length

    }
}