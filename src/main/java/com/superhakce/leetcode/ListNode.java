package com.superhakce.leetcode;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class ListNode {
    int val;
    ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next;}

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, null);
        ListNode list2 = new ListNode(2, null);
        mergeTwoLists(list1, list2);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(null == list1 || null == list2){
            return list1 == null ? list2 : list1;
        }
        ListNode head = null, curr = null;
        if(list1.val >= list2.val){
            head = curr = list2;
            list2 = list2.next;
        }else{
            head = curr = list2;
            list2 = list1.next;
        }
        head.next = curr.next = null;
        while(null != list1 && null != list2){
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        while(null != list1){
            curr.next = list1;
            list1 = list1.next;
            curr = curr.next;
        }
        while(null != list2){
            curr.next = list2;
            list2 = list2.next;
            curr = curr.next;
        }
        return head;
    }
}
