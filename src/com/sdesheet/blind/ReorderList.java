package com.sdesheet.blind;

import java.util.Stack;

public class ReorderList {
    public void reorderList(ListNode head) {
        // reorderListWithExtraSpace(head);
        reorderListNoExtraSpace(head);
    }
    public void reorderListNoExtraSpace(ListNode head) {
        // ListNode center = getCenter(head);
        ListNode center = getCenterSlowFastPtr(head);

        ListNode tailHead = reverse(center.next);

        center.next = null;
        ListNode current = head;
        while (current != null && tailHead != null) {
            ListNode currentNext = current.next;
            ListNode tailNext = tailHead.next;
            current.next = tailHead;
            tailHead.next = currentNext;
            current = currentNext;
            tailHead = tailNext;
        }
    }

    private ListNode getCenterSlowFastPtr(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode getCenter(ListNode head) {
        int centerInd = getLength(head) / 2;
        int ind = 0;
        while (head != null) {
            if (ind == centerInd) {
                return head;
            }
            ind++;
            head = head.next;
        }
        return head;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextHead = head.next;
            head.next = prev;
            prev = head;
            head = nextHead;
        }
        return prev;
    }

    private void reorderListWithExtraSpace(ListNode head) {
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
