package com.home.linked_list.midle_of_linked_list;

import java.util.Objects;

public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (Objects.nonNull(fastPointer) && Objects.nonNull(fastPointer.next)) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }
}
