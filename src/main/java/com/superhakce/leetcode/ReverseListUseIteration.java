package com.superhakce.leetcode;

import java.util.Objects;

/**
 * 反转列表，迭代实现
 *
 * @author Super
 */
public class ReverseListUseIteration {

    public static Node iteration(Node head){
        Node prev = head, curr = head.next, next;
        prev.next = null;
        while (Objects.nonNull(curr)){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static class Node {

        private Integer value;
        private Node next;

        public Node(Integer value, Node next){
            this.value = value;
            this.next = next;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

}
