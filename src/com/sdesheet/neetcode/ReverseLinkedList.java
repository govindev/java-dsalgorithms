package com.sdesheet.neetcode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        ListNode head = constructList(nums);
        reverseList(head);
    }

    public static ListNode constructList(int[] nums) {
        ListNode prev = null, head = null;
        for (int num : nums) {
            ListNode node = new ListNode(num);
            if (prev != null) prev.next = node;
            if (head == null) head = node;
            prev = node;
        }
        return head;
    }

    public static ListNode reverseListIterative(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode newCurr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newCurr;
        }
        return prev;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}



class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

