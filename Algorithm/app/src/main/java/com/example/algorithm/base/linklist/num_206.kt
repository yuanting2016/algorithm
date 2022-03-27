package com.example.algorithm.base.linklist

/**
 * @description: 反转链表
 * @author: tingyuan
 * @date: 2022/3/27
 */
object num_206 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reverseList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return head
        }
        var last = reverseList(head.next)
        head.next!!.next = head
        head.next = null
        return last
    }
}
