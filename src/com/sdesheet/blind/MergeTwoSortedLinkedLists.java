package com.sdesheet.blind;

public class MergeTwoSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode mCurrent = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                mCurrent.next = list1;
                list1 = list1.next;
            } else {
                mCurrent.next = list2;
                list2 = list2.next;
            }
            mCurrent = mCurrent.next;
        }
        if (list1 != null) {
            mCurrent.next = list1;
        }
        if (list2 != null) {
            mCurrent.next = list2;
        }
        return head.next;
    }
}
