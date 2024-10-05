package com.sdesheet.blind;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //  return removeNthFromEndNaive(head, n);
        return removeNthNodeFromEndOnePass(head, n);
    }

    public ListNode removeNthNodeFromEndOnePass(ListNode head, int n) {
        ListNode start = head;
        ListNode end = head;

        ListNode headsPrev = new ListNode();
        headsPrev.next = head;
        ListNode startsPrev = headsPrev;

        int i = 0;
        while (i < n) {
            end = end.next;
            i++;
        }
        while (end != null) {
            startsPrev = start;
            start = start.next;
            end = end.next;
        }
        startsPrev.next = start.next;
        return headsPrev.next;
    }

    public ListNode removeNthFromEndNaive(ListNode head, int n) {
        int length = getLength(head);
        if (length-n-1 < 0) return head.next;
        ListNode beforeNode = getNodeAtIndex(head, length, length-n-1);
        removeNextNode(beforeNode);
        return head;
    }

    private ListNode getNodeAtIndex(ListNode head, int length, int ind) {
        for (int i = 0; i < length; i++) {
            if (i == ind) {
                break;
            }
            head = head.next;
        }
        return head;
    }

    private void removeNextNode(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        head.next = head.next.next;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
