package com.sdesheet.striver;

public class ReverseNodesInKGroup {
    static ListNode reverse(ListNode start, ListNode end) {
        ListNode curr = start, prev = null, next = start.next;

        while (prev != end) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) next = next.next;
        }
        return end;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;

        ListNode start = head, end = head;
        int inc = k-1;
        while (inc-- > 0) {
            end = end.next;
            if (end == null) return head;
        }

        ListNode nextHead = reverseKGroup(end.next, k);
        end = reverse(start, end);

        start.next = nextHead;
        return end;
    }

    public static void main(String[] args) {
        // Construct the linked list
        int[] arr = new int[] {1, 2, 3, 4, 5};
        ListNode head = null, prev = null;
        for (int i = 0; i < arr.length; i++) {
            ListNode curr = new ListNode(arr[i], null);
            if (head == null) head = curr;
            if (prev != null) prev.next = curr;
            prev = curr;
        }
        reverseKGroup(head, 2);
    }
}
