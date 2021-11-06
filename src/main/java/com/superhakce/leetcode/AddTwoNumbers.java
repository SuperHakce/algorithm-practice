package com.superhakce.leetcode;

public class AddTwoNumbers {

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode tmp = listNode;
        int carry = 0;
        while(null != l1 || null != l2){
            int target = carry;
            if(null != l1){
                target += l1.val;
            }
            if(null != l2){
                target += l2.val;
            }
            carry = target / 10;
            target = target % 10;
            tmp.next = new ListNode(target);
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(carry > 0){
            tmp.next = new ListNode(carry);
        }
        return listNode.next;
    }

}
