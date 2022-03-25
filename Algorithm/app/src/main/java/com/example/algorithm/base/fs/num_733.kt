package com.example.algorithm.base.fs

/**
 * @description:有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小。

你也被给予三个整数 sr ,  sc 和 newColor 。你应该从像素 image[sr][sc] 开始对图像进行 上色填充 。

来源：力扣（LeetCode）733
 * @author: tingyuan
 * @date: 2022/3/25
 */
object num_733 {
    @JvmStatic
    fun main(args: Array<String>) {
        val testArray = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1, 0), intArrayOf(1, 0, 1))
        floodFill(testArray, 1, 1, 2).forEach {
            it.forEach {
                System.out.println(it)
            }
        }
    }
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        return dfs(image, sr, sc, newColor, image[sr][sc])
    }
    fun dfs(image: Array<IntArray>, i: Int, j: Int, newColor: Int, num: Int): Array<IntArray> {
        if (i < 0 || i >= image.size || j < 0 || j >= image[0].size || image[i][j] == newColor || image[i][j] != num) {
            return image
        } else {
            val temp = image[i][j]
            image[i][j] = newColor
            dfs(image, i + 1, j, newColor, temp)
            dfs(image, i - 1, j, newColor, temp)
            dfs(image, i, j + 1, newColor, temp)
            dfs(image, i, j - 1, newColor, temp)
        }
        return image
    }
}
