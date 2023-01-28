package com.sdesheet.striver;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Optimised approach
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }
    public ListNode getIntersectionNodeByLengthApproach(ListNode headA, ListNode headB) {
        // Find the lengths of both the lists
        int len1 = 0, len2 = 0;
        ListNode currA = headA;
        while (currA != null) {
            len1++;
            currA = currA.next;
        }
        ListNode currB = headB;
        while (currB != null) {
            len2++;
            currB = currB.next;
        }

        currA = headA; currB = headB;
        if (len1 > len2) {
            // Move the lista by len1-len2 places
            while (len1-len2 > 0) {
                currA = currA.next;
                len1--;
            }
        } else {
            // Move the listb by len2-len1 places
            while (len2-len1 > 0) {
                currB = currB.next;
                len2--;
            }
        }
        // Now both the pointers are at the simillar position from the right
        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }
}
