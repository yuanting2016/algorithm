package com.example.algorithm.base.fs

/**
 * @description:
 * @author: tingyuan
 * @date: 2022/3/25
 */
object num_695 {
    @JvmStatic
    fun main(args: Array<String>) {
        val testArray = arrayOf(
            intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
            intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
            intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
        )
        System.out.println(maxAreaOfIsland(testArray))
    }

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        // 记录岛屿的最大面积
        var res = 0
        val m = grid.size
        val n: Int = grid[0].size
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 1) {
                    // 淹没岛屿，并更新最大岛屿面积
                    res = Math.max(res, dfs(grid, i, j))
                }
            }
        }
        return res
    }

    // 淹没与 (i, j) 相邻的陆地，并返回淹没的陆地面积
    fun dfs(grid: Array<IntArray>, i: Int, j: Int): Int {
        val m = grid.size
        val n: Int = grid[0].size
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return 0
        }
        if (grid[i][j] == 0) {
            // 已经是海水了
            return 0
        }
        // 将 (i, j) 变成海水
        grid[i][j] = 0
        return (
            dfs(grid, i + 1, j) +
                dfs(grid, i, j + 1) +
                dfs(grid, i - 1, j) +
                dfs(grid, i, j - 1) + 1
            )
    }
}
