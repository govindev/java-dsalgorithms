package com.miscellaneous;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Check if elements count is greater than or equal to k
        int tmpK = k;
        ListNode temp = head;
        while (k > 0 && temp != null) {
            temp = temp.next;
            k--;
        }
        // This means elements count is less than k
        if (k > 0) return head;

        // Reset k
        k = tmpK;

        ListNode current = head, prev = null;
        while (k > 0) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
            k--;
        }
        // After the reversal head is the last element, current is the next group start
        // and prev is the start of the current group
        head.next = reverseKGroup(current, tmpK);
        return prev;
    }
}
