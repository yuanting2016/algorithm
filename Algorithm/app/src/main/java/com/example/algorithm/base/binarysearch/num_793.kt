package com.example.algorithm.base.binarysearch

/**
 * @description:阶乘函数后 K 个零
 * @author: tingyuan
 * @date: 2022/4/25
 */
object num_793 {

    @JvmStatic
    fun main(args: Array<String>) {
        println(preimageSizeFZF(125))
    }

    fun preimageSizeFZF(K: Int): Int {
        // 左边界和右边界之差 + 1
        return (right_bound(K) - left_bound(K) + 1).toInt()
    }

    /**
     * 找到阶乘后0的个数
     */
    fun trailingZeroes(n: Long): Long {
        var res = 0L
        var divisor = 5L
        while (divisor <= n) {
            res += n / divisor
            divisor *= 5
        }
        return res
    }

    /**
     * 搜索 trailingZeroes(n) == K 的左侧边界
     */
    fun left_bound(target: Int): Long {
        var lo: Long = 0
        var hi = Long.MAX_VALUE
        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            if (trailingZeroes(mid) < target) {
                lo = mid + 1
            } else if (trailingZeroes(mid) > target) {
                hi = mid
            } else {
                hi = mid
            }
        }
        return lo
    }

    /**
     * 搜索 trailingZeroes(n) == K 的右侧边界
     */
    fun right_bound(target: Int): Long {
        var lo: Long = 0
        var hi = Long.MAX_VALUE
        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            if (trailingZeroes(mid) < target) {
                lo = mid + 1
            } else if (trailingZeroes(mid) > target) {
                hi = mid
            } else {
                lo = mid + 1
            }
        }
        return lo - 1
    }
}
