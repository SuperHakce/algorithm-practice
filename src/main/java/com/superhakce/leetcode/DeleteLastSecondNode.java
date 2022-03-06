package com.superhakce.leetcode;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class DeleteLastSecondNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 边界条件检查
        if(null == head
                || n <= 0
                || (null == head.next && n == 1)){
            return null;
        }
        ListNode node1 = head, node2 = head;
        int i = 1;
        // 双指针初始化
        for(; i <= n; i ++){
            if(null == node2.next){
                break;
            }
            node2 = node2.next;
        }
        // 要删除的元素不存在
        if(i < n - 1){
            return head;
        }
        // 删除的是head节点
        if(i == n){
            return head.next;
        }
        while(true){
            if(null == node2.next){
                node1.next = node1.next.next;
                break;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return head;
    }
}
