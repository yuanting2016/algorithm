package com.example.algorithm.base.linklist

/**
 * @description:给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * @author: tingyuan
 * @date: 2022/4/6
 */
object num_203 {

    fun removeElements(head: ListNode?,  `val`: Int): ListNode? {
        val header = ListNode(-1)
        header.next = head
        var cur = header
        while (cur.next != null) {
            if(cur.next!!.`val` == `val`) {
                cur.next = cur.next?.next
            } else {
                cur = cur.next!!
            }
        }
        return header.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null

}