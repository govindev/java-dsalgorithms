package com.miscellaneous;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        // Slow and Fast tortoize approach
        ListNode slow = head, fast = head;
        while (true) {
            if (slow == null || fast == null || fast.next == null) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
    }

    public ListNode middleNodeLenApproach(ListNode head) {
        // 1. Find the length of the list
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        int ind = 0;
        curr = head;
        while (curr != null) {
            ind++;
            if (ind == (len/2 + 1)) return curr;
            curr = curr.next;
        }
        return null;
    }
}
