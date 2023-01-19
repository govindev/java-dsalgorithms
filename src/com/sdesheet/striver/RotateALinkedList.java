package com.sdesheet.striver;

public class RotateALinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        // Find the length
        // Find the lastNode

        ListNode curr = head, lastNode = null;
        int len = 0;
        while (curr != null) {
            len++;
            if (curr.next == null) lastNode = curr;
            curr = curr.next;
        }

        if (len == 0) return head;
        k = k % len;
        if (k == 0) return head;

        curr = head;
        int i = 0;
        ListNode newHead = null;
        while (curr != null) {
            i++;
            if (i == (len - k)) {
                newHead = curr.next;
                curr.next = null;
                break;
            }
            curr = curr.next;
        }
        lastNode.next = head;
        return newHead;
    }
}
