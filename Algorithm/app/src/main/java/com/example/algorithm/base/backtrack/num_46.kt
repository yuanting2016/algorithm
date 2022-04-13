package com.example.algorithm.base.backtrack

import java.util.*

/**
 * @description:给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @author: tingyuan
 * @date: 2022/4/13
 */
object num_46 {
    @JvmStatic
    fun main(args: Array<String>) {
        permute(intArrayOf(1, 2, 3))?.forEach(action = {
            it?.forEach { temp ->
                println(temp)
            }
        })
    }

    var res: MutableList<List<Int?>?> = LinkedList()

    fun permute(nums: IntArray): List<List<Int?>?>? {

        // 记录回溯算法的递归路径
        var track: LinkedList<Int> = LinkedList()
        backtrack(nums, track)
        return res
    }

    fun backtrack(nums: IntArray, track: LinkedList<Int>) {
        println("backtrack")
        if (nums.size == track.size) {
            println("nums.size == track.size${LinkedList(track)}")
            res.add(LinkedList(track))
            return
        }

        for (i in nums.indices) {
            if (track.contains(nums[i])) {
                println("track.contains(nums[i])${nums[i]}")
                continue
            }
            println("track.addLast(nums[i])${nums[i]}")
            track.addLast(nums[i])
            backtrack(nums, track)
            // 撤销选择
            println("track.removeLast()${track.last}")
            track.removeLast()
        }
    }
}
