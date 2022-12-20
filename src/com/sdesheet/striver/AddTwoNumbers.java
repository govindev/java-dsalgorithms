package com.sdesheet.striver;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null, curr = null, prev = null;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int val = ((l1 != null) ? l1.val : 0)
                    + ((l2 != null) ? l2.val : 0)
                    + carry;
            carry = 0;
            if (val > 9) {
                carry = val / 10;
                val = val % 10;
            }
            // System.out.println("val: "+ val +", carry:" + carry);
            curr = new ListNode(val, null);
            if (prev == null) res = curr;
            else prev.next = curr;
            prev = curr;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return res;
    }
}
