package com.home.topic_006_linked_list.linked_list_cycle;

import com.home.topic_006_linked_list.ListNode;

import java.util.Objects;

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        // Add cycle
//        node4.next = node2;

        Solution solution = new Solution();
        System.out.println(solution.hasCycle(head));
    }
}
