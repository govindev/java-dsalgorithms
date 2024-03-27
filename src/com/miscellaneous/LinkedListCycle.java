package com.miscellaneous;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head; ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) return false;
            fast = fast.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
