package com.example.algorithm.base.linklist

/**
 * @description:给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * @author: tingyuan
 * @date: 2022/4/11
 */
object num_142 {
    fun detectCycle(head: ListNode?): ListNode? {
        var fast: ListNode? = null
        var slow: ListNode? = null
        fast = head
        slow = head
        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
            if (fast == slow) {
                break
            }
        }
        if (fast?.next == null) {
            return null
        }
        slow = head
        while (slow != fast) {
            fast = fast?.next
            slow = slow?.next
        }
        return slow
    }
}
