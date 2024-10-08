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



    public ListNode mergeKLists2(ListNode[] lists) {
        // 10(1)
        // 5(1) + 5(1)
        // 3(1) + 2(1) + 3(1) + 2(1)
        // 2(1) + 1(0) + 1(0) + 1(0) + 2(1) + 1(0) + 1(0) + 1(0)
        return merge(lists, 0, lists.length-1);
    }


    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start > lists.length-1 || end < 0) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode leftNode = merge(lists, start, mid);
        ListNode rightNode = merge(lists, mid+1, end);
        return merge(leftNode, rightNode);
    }

    private ListNode merge2(ListNode node1, ListNode node2) {
        ListNode dummyNode = new ListNode();
        ListNode current = dummyNode;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                current.next = node1;
                node1 = node1.next;
            } else {
                current.next = node2;
                node2 = node2.next;
            }
            current = current.next;
        }
        if (node1 != null) {
            current.next = node1;
        } else {
            current.next = node2;
        }
        return dummyNode.next;
    }
}