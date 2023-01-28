package com.miscellaneous;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0), curr = dummy;

        while (l1 != null || l2 != null || carry != 0) {
            int num = carry;
            if (l1 != null) num += l1.val;
            if (l2 != null) num += l2.val;

            curr.next = new ListNode(num % 10);
            curr = curr.next;
            carry = num / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}
