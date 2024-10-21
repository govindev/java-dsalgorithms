package com.sdesheet.blind;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // return removeNthFromEndTwoPass(head, n);
        return removeNthFromEndOnePass(head, n);
    }

    public ListNode removeNthFromEndOnePass(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < n-1; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;

        return dummy.next;
    }

    public ListNode removeNthFromEndTwoPass(ListNode head, int n) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        if (n == 0 || n > length) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;

        int ind = (length-n) + 1;
        current = dummy;
        int i = 0;
        while (current != null) {
            if (i == ind-1) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
            i++;
        }

        return dummy.next;
    }
}
