package com.superhakce.leetcode;

import java.util.Objects;

/**
 * 反转列表，递归实现
 *
 * @author Super
 */
public class ReverseListUseRecursion {

    public static void main(String[] args) {
        Node node3 = new Node(3, null);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        Node result = recursion(node1);
        System.out.println("OK");
    }

    public static Node recursion(Node head){
        if(Objects.isNull(head.next)){
            return head;
        }
        Node result = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return result;
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

