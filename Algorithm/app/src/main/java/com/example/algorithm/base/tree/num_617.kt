package com.example.algorithm.base.tree

import com.example.algorithm.base.slidewindow.num_567

/**
 * @description:
 * @author: tingyuan
 * @date: 2022/3/26
 */
object num_617 {
    @JvmStatic
    fun main(args: Array<String>) {
        val testArray = "ab"
        val s2 = "eidbaooo"
        var root1 = TreeNode(1)
        var roo1Left = TreeNode(3)
        roo1Left.left = TreeNode(5)
        root1.left = roo1Left
        var root1Right = TreeNode(2)
        root1.right = root1Right

//        System.out.println(mergeTrees(root1, root2))
    }
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
      if(root1 == null) {
        return root2
      }
        if (root2 == null) {
            return root1
        }
        return dfs(root1,root2)
    }

    fun dfs(root1: TreeNode?,root2: TreeNode?):TreeNode? {
        if (root1 == null) {
            return root2
        }
        if (root2 == null) {
            return root1
        }
        root1.`val` += root2.`val`
        root1.left = mergeTrees(root1.left, root2.left)
        root1.right = mergeTrees(root1.right, root2.right)

        return root1
    }

}
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}