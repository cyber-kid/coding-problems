package com.home.topic_006_linked_list.reorder_list;

import com.home.topic_006_linked_list.ListNode;

import java.util.Objects;

public class Solution {
    public void reorderList(ListNode head) {
        ListNode middleNode = findMiddleNode(head);

        ListNode reversedSecondPart = reverseList(middleNode.next);
        middleNode.next = null;

        head = mergeLists(head, reversedSecondPart);
    }

    private ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (Objects.nonNull(current)) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }

    private ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (Objects.nonNull(list1) && Objects.nonNull(list2)) {
            ListNode temp1 = list1.next;
            ListNode temp2 = list2.next;

            tail.next = list1;
            tail = tail.next;

            tail.next = list2;
            tail = tail.next;

            list1 = temp1;
            list2 = temp2;
        }

        if (Objects.nonNull(list1)) {
            tail.next = list1;
        }

        if (Objects.nonNull(list2)) {
            tail.next = list2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        ListNode print = head;

        System.out.println(print.val);
        while (Objects.nonNull(print.next)) {
            print = print.next;
            System.out.println(print.val);
        }

        Solution solution = new Solution();
        solution.reorderList(head);

        System.out.println("Reversed");
        System.out.println(head.val);
        while (Objects.nonNull(head.next)) {
            head = head.next;
            System.out.println(head.val);
        }
    }
}
