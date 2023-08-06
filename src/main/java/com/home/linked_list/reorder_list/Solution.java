package com.home.linked_list.reorder_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> store = new ArrayList<>();

        while (Objects.nonNull(head)) {
            store.add(head);

            head = head.next;
        }

        ListNode tail = store.get(0);
        int leftIndex = 1;
        int rightIndex = store.size() - 1;
        for (int i = 1; i < store.size(); i++) {
            if (i / 2 == 0) {
                tail.next = store.get(leftIndex);
                leftIndex++;
            } else {
                tail.next = store.get(rightIndex);
                rightIndex--;
            }
            tail = tail.next;

        }

        tail.next = null;
    }

    public static void main(String[] args) {
        System.out.println(1 % 2);
    }
}
