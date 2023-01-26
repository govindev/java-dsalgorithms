package com.miscellaneous;

public class DeleteAGivenNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
