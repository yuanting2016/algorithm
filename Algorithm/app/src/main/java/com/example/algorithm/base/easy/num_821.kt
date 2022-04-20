package com.example.algorithm.base.easy

import kotlin.math.abs

/**
 * @description: 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。

返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。

两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: tingyuan
 * @date: 2022/4/19
 */

object num_821 {

    @JvmStatic
    fun main(args: Array<String>) {
        shortestToChar("loveleetcode", 'e').forEach {
            println(it)
        }
//        shortestToChar("aaab", 'b').forEach {
//            println(it)
//        }
    }

    fun shortestToChar(s: String, c: Char): IntArray {
        val res = arrayListOf<Int>()
        for (i in s.toCharArray().indices) {
            var leftIndex = -1
            for (left in i downTo 0) {
                if (s.toCharArray()[left] == c) {
                    leftIndex = abs(left - i)
                    break
                }
            }
            var rightIndex = -1
            for (right in i..s.toCharArray().lastIndex) {
                if (s.toCharArray()[right] == c) {
                    rightIndex = abs(right - i)
                    break
                }
            }
            if (rightIndex == -1) {
                res.add(leftIndex)
            } else if (leftIndex == -1) {
                res.add(rightIndex)
            } else {
                if (rightIndex >= leftIndex) {
                    res.add(leftIndex)
                } else {
                    res.add(rightIndex)
                }
            }
        }
        return res.toIntArray()
    }
}
