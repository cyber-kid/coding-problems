package com.home.task_026_linked_list_cycle;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> store = new HashMap<>();
        int pos = 0;

        while (Objects.nonNull(head)) {
            if (store.containsKey(head)) {
                System.out.println(store.get(head));
                return true;
            }

            store.put(head, pos++);
            head = head.next;
        }

        return false;
    }
}
