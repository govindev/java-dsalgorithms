package com.sdesheet.blind;

import java.util.ArrayList;
import java.util.List;

class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return merge(lists[0], lists[1]);
        }
        List<ListNode> result = new ArrayList<>();
        int i = 0;
        while (i < lists.length) {
            result.add(merge(lists[i], (i+1) < lists.length ? lists[i+1] : null));
            i += 2;
        }
        return mergeKLists(result.toArray(new ListNode[result.size()]));
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode();
        ListNode current = dummyNode;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                current.next = head1;
                head1 = head1.next;
            }
            else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
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