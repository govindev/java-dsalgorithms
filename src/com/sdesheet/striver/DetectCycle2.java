package com.sdesheet.striver;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        // Using the fast and slow pointer approach
        ListNode slow = head, fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next == null) return null;
            fast = fast.next.next;
            if (slow == null || fast == null) return null;
            if (slow == fast) break;
        }
        ListNode entry = head;
        while (true) {
            if (entry == slow) return slow;
            entry = entry.next;
            slow = slow.next;
        }

    }

    public ListNode detectCycleNaive(ListNode head) {
        if (head == null) return null;

        // Here we are using an extra space for keeping track of the traversed nodes
        Set<ListNode> set = new HashSet<>();

        ListNode current = head;
        while (current != null) {
            if (set.contains(current)) {
                return current;
            }
            set.add(current);
            current = current.next;
        }
        return null;
    }
}
