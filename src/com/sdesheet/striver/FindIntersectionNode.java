package com.sdesheet.striver;

import java.util.HashSet;
import java.util.Set;

public class FindIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Constant space
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }
    public ListNode getIntersectionNodeLinearTime(ListNode headA, ListNode headB) {
        // Linear time
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) return headB;
            set.add(headB);
            headB = headB.next;
        }
        return null;
    }
}
