package com.sdesheet.striver;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        // Slow and Fast Tortize approach
        ListNode slow = head, fast = head;
        while (true) {
            if (slow == null || fast == null || fast.next == null) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
    }

    public ListNode middleNodeBruteForce(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        int findInd = count/2; count = 0;
        curr = head;
        while (curr != null) {
            if (findInd == count) return curr;
            count++;
            curr = curr.next;
        }

        return curr;
    }
}
