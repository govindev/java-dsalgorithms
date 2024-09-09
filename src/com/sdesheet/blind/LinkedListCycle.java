package com.sdesheet.blind;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            if (slow == null) return false;
            slow = slow.next;

            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
    }
}
