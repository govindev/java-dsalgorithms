package com.sdesheet.blind;

import java.util.Stack;

public class ReorderList {
    public void reorderList(ListNode head) {
        // reorderListWithExtraSpace(head);
        reorderListWithoutExtraSpace(head);
    }


    public void reorderListWithoutExtraSpace(ListNode head) {
        if (head == null) {
            return;
        }
        // 1. Find the middle node
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2. Reverse the second half
        ListNode secHalfHead = slow.next, prev = null;
        slow.next = null;
        while (secHalfHead != null) {
            ListNode temp = secHalfHead.next;
            secHalfHead.next = prev;
            prev = secHalfHead;
            secHalfHead = temp;
        }
        secHalfHead = prev;

        // 3. Now do the merge
        ListNode current = head, newCurrent = null;
        while (current != null && secHalfHead != null) {
            newCurrent = current.next;
            current.next = secHalfHead;
            ListNode newSecHalfHead = secHalfHead.next;
            secHalfHead.next = newCurrent;
            secHalfHead = newSecHalfHead;
            current = newCurrent;
        }
    }

    public void reorderListWithExtraSpace(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            stack.push(current);
            current = current.next;
        }

        current = head;
        int i = 1;
        while (i < length) {
            ListNode top = stack.pop();
            ListNode currentNext = current.next;

            current.next = top;
            top.next = currentNext;
            current = currentNext;

            i += 2;
        }
        current.next = null;
    }
}
