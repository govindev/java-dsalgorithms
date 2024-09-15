package com.sdesheet.blind;

import java.util.Stack;

public class ReorderList {
    public void reorderList(ListNode head) {
        // reorderListWithExtraSpace(head);
        reorderListWithoutExtraSpace(head);
    }

    public void reorderListWithoutExtraSpace(ListNode head) {
        ListNode mid = getMid(head);
        ListNode secondHalfHead = reverseList(mid.next);
        mid.next = null;

        ListNode firstHalfCurrent = head, secondHalfCurrent = secondHalfHead;
        while (firstHalfCurrent != null && secondHalfCurrent != null) {
            ListNode firstHalfCurrentNext = firstHalfCurrent.next;
            ListNode secondHalfCurrentNext = secondHalfCurrent.next;

            firstHalfCurrent.next = secondHalfCurrent;
            secondHalfCurrent.next = firstHalfCurrentNext;

            firstHalfCurrent = firstHalfCurrentNext;
            secondHalfCurrent = secondHalfCurrentNext;
        }
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode currentNext = current.next;
            current.next = prev;
            prev = current;
            current = currentNext;
        }
        return prev;
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
