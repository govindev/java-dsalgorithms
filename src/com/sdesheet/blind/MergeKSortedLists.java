package com.sdesheet.blind;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) return null;
        List<ListNode> nodes = new ArrayList<>();
        int i = 0;
        while (i < lists.length) {
            ListNode mergedNode = merge(lists[i], (i+1 < lists.length) ? lists[i+1] : null);
            nodes.add(mergedNode);
            i += 2;
        }
        if (nodes.size() == 1) return nodes.get(0);
        return mergeKLists(nodes.toArray(new ListNode[nodes.size()]));
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode();
        ListNode current = dummyNode;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                current.next = head1;
                head1 = head1.next;
                current = current.next;
            } else {
                current.next = head2;
                head2 = head2.next;
                current = current.next;
            }
        }
        if (head1 != null) {
            current.next = head1;
        }
        if (head2 != null) {
            current.next = head2;
        }
        return dummyNode.next;
    }
}
