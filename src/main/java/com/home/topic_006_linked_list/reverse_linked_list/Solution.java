package com.home.topic_006_linked_list.reverse_linked_list;

import com.home.topic_006_linked_list.ListNode;

import java.util.Objects;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;

        while (Objects.nonNull(current)) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        return previous;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (Objects.isNull(head.next)) {
            return head;
        }

        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode head = node1;

        System.out.println(head.val);
        while (Objects.nonNull(head.next)) {
            head = head.next;
            System.out.println(head.val);
        }

        Solution solution = new Solution();
        head = solution.reverseListRecursive(node1);

        System.out.println("Reversed");
        System.out.println(head.val);
        while (Objects.nonNull(head.next)) {
            head = head.next;
            System.out.println(head.val);
        }
    }
}
