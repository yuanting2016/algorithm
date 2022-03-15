package com.example.algorithm.base.doublepointer

/**
 * @description:给定一个头结点为 head 的非空单链表，返回链表的中间结点。

如果有两个中间结点，则返回第二个中间结点。
 * @author: tingyuan
 * @date: 2022/3/15
 */
object num_876 {
    /**
     * 一次遍历，找到中间节点
     *  定义两个指针，快指针和慢指针
     *  快指针一次走两步，慢指针一次走一步
     *  当快指针走到尾，慢指针所指的位置就是中间节点
     */
    fun middleNode(head: ListNode?): ListNode? {
        // 快慢指针初始化指向 head
        var slow = head
        var fast = head
        // 快指针走到末尾时停止
        while (fast?.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow?.next
            fast = fast.next?.next
        }
        // 慢指针指向中点
        return slow
    }

}
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}