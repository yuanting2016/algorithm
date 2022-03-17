package com.example.algorithm.base

import java.util.*

/**
 * @description:给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。

若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 * @author: tingyuan
 * @date: 2022/3/17
 */
object num_720 {
    @JvmStatic
    fun main(args: Array<String>) {
        val testArray = arrayOf("w", "wo", "wor", "worl", "world")
        System.out.println(longestWord(testArray))
    }

    /**
     * 先排序，再用hashset
     */
    private fun longestWord(words: Array<String>): String? {
        Arrays.sort(
            words
        ) { a: String, b: String ->
            if (a.length != b.length) {
                return@sort a.length - b.length
            } else {
                return@sort b.compareTo(a)
            }
        }
        var longest: String? = ""
        val set: MutableSet<String> = HashSet()
        set.add("")
        val n = words.size
        for (i in 0 until n) {
            val word = words[i]
            if (set.contains(word.substring(0, word.length - 1))) {
                set.add(word)
                longest = word
            }
        }
        return longest
    }
}
