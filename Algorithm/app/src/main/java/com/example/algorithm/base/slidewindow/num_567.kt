package com.example.algorithm.base.slidewindow

import java.util.*

/**
 * @description:给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。

换句话说，s1 的排列之一是 s2 的 子串 。
 滑动窗口的思想来做这道题，巧妙之处是用到字母的ascii码值与a的差来作为数组下标，表示当前字母。
 具体下标上的值表示出现的个数
 * @author: tingyuan
 * @date: 2022/3/18
 */
object num_567 {
    @JvmStatic
    fun main(args: Array<String>) {
        val testArray = "ab"
        val s2 = "eidbaooo"
        System.out.println(checkInclusion(testArray, s2))
    }
    fun checkInclusion(s1: String, s2: String): Boolean {
        var n = s1.length
        var m = s2.length
        if (n > m) {
            return false
        }
        var cnt1 = IntArray(26)
        var cnt2 = IntArray(26)
        for (i in 0..n - 1) {
            cnt1[s1.toCharArray()[i] - 'a'] ++
            cnt2[s2.toCharArray()[i] - 'a'] ++
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true
        }
        for (i in n..m - 1) {
            cnt2[s2.toCharArray()[i] - 'a'] ++
            cnt2[s2.toCharArray()[i - n] - 'a'] --
            if (Arrays.equals(cnt1, cnt2)) {
                return true
            }
        }
        return false
    }
}
