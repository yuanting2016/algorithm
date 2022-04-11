package com.example.algorithm.base.backtrack

import java.util.*

/**
 *    @date :2022/4/11
 *    @author:yuanting
 *    @des:  给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
      你可以按 任何顺序 返回答案。
 */
object num_77 {
    @JvmStatic
    fun main(args: Array<String>) {
        combine(4,2)?.forEach(action = {
            it?.forEach{temp ->
                System.out.println(temp)
            }
        })
    }

    var res: MutableList<List<Int?>?> = LinkedList()

    // 记录回溯算法的递归路径
    var track: LinkedList<Int> = LinkedList()

    // 主函数
    fun combine(n: Int, k: Int): List<List<Int?>?>? {
        backtrack(1, n, k)
        return res
    }

    fun backtrack(start: Int, n: Int, k: Int) {
        // base case
        if (k == track.size) {
            // 遍历到了第 k 层，收集当前节点的值
            res.add(LinkedList(track))
            return
        }

        // 回溯算法标准框架
        for (i in start..n) {
            // 选择
            track.addLast(i)
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(i + 1, n, k)
            // 撤销选择
            track.removeLast()
        }
    }

}