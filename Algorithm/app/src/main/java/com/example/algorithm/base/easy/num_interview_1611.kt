package com.example.algorithm.base.easy

/**
 * @description:你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。
 * 你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
返回的长度需要从小到大排列。
 * @author: tingyuan  2
1118596
979
 * @date: 2022/4/21
 */
object num_interview_1611 {

    @JvmStatic
    fun main(args: Array<String>) {
        divingBoard(2, 1, 10000)?.forEach {
            println(it)
        }
    }

    fun divingBoard(shorter: Int, longer: Int, k: Int): IntArray {
        if (k == 0) {
            return intArrayOf()
        }
        if (shorter == longer) {
            return intArrayOf(shorter * k)
        }
        val res = HashSet<Int>(k + 1)
        for (i in 0..k) {
            val temp: Int = i * longer + (k - i) * shorter
            if (!res.contains(temp)) {
                res.add(temp)
            }
        }
        val result = res.toIntArray()
        result.sort()
        return result
    }
}
