package com.example.algorithm.base.backtrack

import java.lang.StringBuilder

/**
 * @description:给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 * @author: tingyuan
 * @date: 2022/4/13
 */
object num_784 {
    @JvmStatic
    fun main(args: Array<String>) {
        letterCasePermutation("a1b2")?.forEach {
            println(it)
        }
    }

    fun letterCasePermutation(S: String): List<String>? {
        val ans: MutableList<StringBuilder> = ArrayList()
        ans.add(StringBuilder())
        for (c in S.toCharArray()) {
            val n = ans.size
            if (Character.isLetter(c)) {
                for (i in 0 until n) {
                    ans.add(StringBuilder(ans[i]))
                    ans[i].append(Character.toLowerCase(c))
                    ans[n + i].append(Character.toUpperCase(c))
                }
            } else {
                for (i in 0 until n) ans[i].append(c)
            }
        }
        val result: MutableList<String> = ArrayList()
        for (sb in ans) {
            result.add(sb.toString())
        }
        return result
    }
}
