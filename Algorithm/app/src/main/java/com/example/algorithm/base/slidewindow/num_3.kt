package com.example.algorithm.base.slidewindow

/**
 * @description:给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 *
 * @author: tingyuan
 * @date: 2022/3/15
 */
object num_3 {
    @JvmStatic
    fun main(args: Array<String>) {
        val testArray = "au"
        System.out.println(lengthOfLongestSubstring(testArray))
    }
    fun lengthOfLongestSubstring(s: String): Int {
        val tempList = HashSet<Char>()
        var currentLongest = 0
        val char = s.toCharArray()
        var left = 0
        var realIndex = 0
        if (s.length == 1) {
            return 1
        }
        while (left < char.size) {
            for (i in left until char.size) {
                if (!tempList.contains(char[i])) {
                    tempList.add(char[i])
                    left ++
                } else {
                    if (currentLongest < tempList.size) {
                        currentLongest = tempList.size
                    }
                    realIndex ++
                    left = realIndex
                    tempList.clear()
                    break
                }
            }
        }
        if ((tempList.size - currentLongest) > 0) {
            currentLongest = tempList.size
        }
        return currentLongest
    }
}
