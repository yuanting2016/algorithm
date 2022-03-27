package com.example.algorithm.base.linklist

/**
 * @description:合并两个链表
 * @author: tingyuan
 * @date: 2022/3/27
 */
object num_27 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var dumpy = ListNode(-1)
        var p = dumpy
        var p1 = list1
        var p2 = list2
        while (p1 != null && p2 != null) {
            if (p1.`val` > p2.`val`) {
                p.next = p2
                p2 = p2.next
            } else {
                p.next = p1
                p1 = p1.next
            }
            p = p.next!!
        }
        if (p1 != null) {
            p.next = p1
        }
        if (p2 != null) {
            p.next = p2
        }
        return dumpy.next
    }
}
