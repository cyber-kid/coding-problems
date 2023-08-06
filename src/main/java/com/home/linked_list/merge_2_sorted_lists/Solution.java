package com.home.linked_list.merge_2_sorted_lists;

import java.util.Objects;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (Objects.nonNull(list1) && Objects.nonNull(list2)) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (Objects.nonNull(list1)) {
            tail.next = list1;
        }

        if (Objects.nonNull(list2)) {
            tail.next = list2;
        }

        return dummy.next;
    }


}
