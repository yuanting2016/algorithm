package com.example.algorithm.base.tree

/**
 * @description:
 * @author: tingyuan
 * @date: 2022/4/7
 */
object num_101 {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        return check(root.left, root.right)
    }

    fun check(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null || right == null) {
            return left == right
        }
        if (left.`val` != right.`val`) {
            return false
        }
        return check(left.right, right.left) && check(left.left, right.right)
    }
}
