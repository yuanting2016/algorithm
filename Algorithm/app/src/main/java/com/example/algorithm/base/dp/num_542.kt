package com.example.algorithm.base.dp

import java.util.*

/**
 * @description: 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。

两个相邻元素间的距离为 1

 * @author: tingyuan
 * @date: 2022/4/14
 */
object num_542 {

    @JvmStatic
    fun main(args: Array<String>) {
        // 这道题思路不够清晰，答案参考的官方题解
        System.out.println(
            updateMatrix(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 0)
                )
            )
        )
    }

    var dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray>? {
        val m = matrix.size
        val n: Int = matrix[0].size
        val dist = Array(m) { IntArray(n) }
        val seen = Array(m) {
            BooleanArray(
                n
            )
        }
        val queue: Queue<IntArray> = LinkedList<IntArray>()
        // 将所有的 0 添加进初始队列中
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == 0) {
                    queue.offer(intArrayOf(i, j))
                    seen[i][j] = true
                }
            }
        }

        // 广度优先搜索
        while (!queue.isEmpty()) {
            val cell: IntArray = queue.poll()
            val i = cell[0]
            val j = cell[1]
            for (d in 0..3) {
                val ni = i + dirs[d][0]
                val nj = j + dirs[d][1]
                if (ni in 0 until m && nj >= 0 && nj < n && !seen[ni][nj]) {
                    dist[ni][nj] = dist[i][j] + 1
                    queue.offer(intArrayOf(ni, nj))
                    seen[ni][nj] = true
                }
            }
        }
        return dist
    }
}
