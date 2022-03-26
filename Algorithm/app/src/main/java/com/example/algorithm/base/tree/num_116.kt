package com.example.algorithm.base.tree

/**
 * @description:
 * @author: tingyuan
 * @date: 2022/3/26
 */
class num_116 {
     class Node(var `val`: Int) {
          var left: Node? = null
           var right: Node? = null
            var next: Node? = null
     }
    fun connect(root: Node?): Node? {
        if(root == null) {
            return null
        }
        if(root.left != null) {
            root.left!!.next = root.right;
            if(root.next != null) {
                root.right?.next = root.next!!.left
            }
        }
        connect(root.left)
        connect(root.right)
        return root
    }
}
