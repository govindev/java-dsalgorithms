package com.sdesheet.striver;

public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        // Simple, Optimal approach
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public void deleteNodeComplex(ListNode node) {
        ListNode prev = node;

        while (node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }
}
