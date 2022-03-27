package com.example.algorithm.base

/**
 * @description:
 * @author: tingyuan
 * @date: 2022/3/27
 */
object num_2160 {
    @JvmStatic
    fun main(args: Array<String>) {
        val testArray = "au"
        System.out.println(minimumSum(4009))
    }
    fun minimumSum(num: Int): Int {
        val qianwei = num / 1000
        val baiwei = (num - qianwei * 1000) / 100
        val shiwei = (num - qianwei * 1000 - baiwei * 100) / 10
        val gewei = num - qianwei * 1000 - baiwei * 100 - shiwei * 10
        val arr = arrayListOf<Int>(qianwei, baiwei, shiwei, gewei)
        arr.sort()
        val nums1: Int = arr[0] * 10 + arr[3]
        val nums2: Int = arr[1] * 10 + arr[2]
        return nums1 + nums2
    }
}
