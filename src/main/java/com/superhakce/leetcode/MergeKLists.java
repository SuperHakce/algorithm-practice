package com.superhakce.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next;
 * }
 * @author Super
 */
public class MergeKLists {

    public ListNode mergeKListsPriorityQueue(ListNode[] lists) {
        if(Objects.isNull(lists) || lists.length <= 0){return null;}
        if(lists.length == 1){return lists[0];}
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue(500, Comparator.comparingInt(a -> ((ListNode) a).val));
        ListNode now = null;
        ListNode head = null;
        for (ListNode list : lists) {
            if(Objects.nonNull(list)){
                priorityQueue.add(list);
            }
        }
        while (true){
            ListNode listNode = priorityQueue.poll();
            if(Objects.isNull(listNode)){
                break;
            }
            if(Objects.isNull(now)){
                now = new ListNode(listNode.val);
                head = now;
            }else {
                now.next = new ListNode(listNode.val);
                now = now.next;
            }
            if(Objects.nonNull(listNode.next)){
                priorityQueue.add(listNode.next);
            }
        }
        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(Objects.isNull(lists) || lists.length <= 0){return null;}
        if(lists.length == 1){return lists[0];}
        ListNode listNode = null;
        ListNode now, head = null;
        int index;
        int second = Integer.MIN_VALUE;
        while (true){
            now = null;
            index = -1;
            for (int i = 0; i < lists.length; i++) {
                if(Objects.isNull(lists[i])){continue;}
                if(Objects.isNull(now)){
                    now = lists[i];
                    second = now.val;
                    index = i;
                }else if(lists[i].val < now.val){
                    second = now.val;
                    now = lists[i];
                    index = i;
                }else if(lists[i].val < second){
                    second = lists[i].val;
                }
            }
            if(Objects.isNull(now)){
                break;
            }
            while (true){
                if(Objects.nonNull(now) && now.val <= second){
                    if(Objects.isNull(listNode)){
                        listNode = new ListNode(now.val);
                        head = listNode;
                    }else {
                        listNode.next = new ListNode(now.val);
                        listNode = listNode.next;
                    }
                    lists[index] = lists[index].next;
                    now = lists[index];
                }else {break;}
            }
        }
        return head;
    }

    public static class ListNode {

        int val;

        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

}
