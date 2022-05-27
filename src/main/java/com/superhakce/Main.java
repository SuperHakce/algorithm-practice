package com.superhakce;

import com.superhakce.leetcode.MergeKLists;

public class Main {

    /**
     * [[1,4,5],[1,3,4],[2,6]]
     * @param args
     */
    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();
        MergeKLists.ListNode listNode11 = new MergeKLists.ListNode(6);
        MergeKLists.ListNode listNode1 = new MergeKLists.ListNode(2, listNode11);

        MergeKLists.ListNode listNode22 = new MergeKLists.ListNode(5);
        MergeKLists.ListNode listNode21 = new MergeKLists.ListNode(4, listNode22);
        MergeKLists.ListNode listNode2 = new MergeKLists.ListNode(1, listNode21);

        MergeKLists.ListNode listNode32 = new MergeKLists.ListNode(4);
        MergeKLists.ListNode listNode31 = new MergeKLists.ListNode(3, listNode32);
        MergeKLists.ListNode listNode3 = new MergeKLists.ListNode(1, listNode31);
        mergeKLists.mergeKListsPriorityQueue(new MergeKLists.ListNode[]{listNode2, listNode3, listNode1});
    }

}
