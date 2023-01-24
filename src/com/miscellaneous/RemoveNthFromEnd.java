package com.miscellaneous;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. Find the length of the list
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        // 2. Remove the node (len-n+1)
        if (len-n+1 == 1) return head.next;

        curr = head;
        int i = 1;
        while (i < len-n) {
            curr = curr.next;
            i++;
        }
        curr.next = curr.next.next;
        return head;
    }
}
