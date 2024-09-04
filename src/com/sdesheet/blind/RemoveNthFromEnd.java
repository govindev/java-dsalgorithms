package com.sdesheet.blind;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = countNumberOfNodes(head);
        int deleteIndex = relativeZeroIndexStartNumberForLast(n, length);

        ListNode startNode = new ListNode(0, head), prevNode = startNode;
        ListNode currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if (index == deleteIndex) {
                prevNode.next = currentNode.next;
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
            index++;
        }

        return startNode.next;
    }

    private int countNumberOfNodes(ListNode head) {
        int numberOfNodes = 0;
        while (head != null) {
            head = head.next;
            numberOfNodes++;
        }
        return numberOfNodes;
    }

    private int relativeZeroIndexStartNumberForLast(int last, int length) {
        return length - last;
    }
}
