package com.sdesheet.blind;

public class ReverseLinkedList {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = reverseLinkedList.constructList(nums);
        reverseLinkedList.reverseList(head);
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

    public ListNode reverseList(ListNode head) {
        // return reverseListIterative(head);
        return reverseListRecursive(head, null);
    }

    private ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;

            current = next;
        }
        return prev;
    }

    private ListNode reverseListRecursive(ListNode head, ListNode prev) {
        if (head != null) {
            ListNode next = head.next;
            head.next = prev;

            return reverseListRecursive(next, head);
        }
        return prev;
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

