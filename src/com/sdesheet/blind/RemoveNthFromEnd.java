package com.sdesheet.blind;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        // 5 - 2
        int i = 0;
        ListNode headsHead = new ListNode(0, head);
        curr = headsHead;
        while (curr != null) {
            if (length-n == i) {
                // Remove the next node
                curr.next = curr.next.next;
                return headsHead.next;
            }
            curr = curr.next; i++;
        }
        return null;
    }
}
