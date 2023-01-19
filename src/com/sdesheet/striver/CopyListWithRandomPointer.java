package com.sdesheet.striver;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public NodeA copyRandomList(NodeA head) {
        // Step1 : Create the new Nodes
        NodeA curr = head;
        while (curr != null) {
            NodeA newCurr = new NodeA(curr.val);
            NodeA next = curr.next;

            curr.next = newCurr;
            newCurr.next = next;

            curr = next;
        }

        // Step2 : Fix the random pointers for the new nodes
        curr = head;
        while (curr != null) {
            NodeA newCurr = curr.next;
            newCurr.random = (curr.random == null) ? null : curr.random.next;

            curr = newCurr.next;
        }


        // Step3 : Fix the next pointers for all the nodes
        curr = head;
        NodeA dummy = new NodeA(0), temp = dummy;
        while (curr != null) {
            NodeA newCurr = curr.next;
            curr.next = newCurr.next;
            temp.next = newCurr;
            temp = temp.next;
            curr = curr.next;
        }

        return dummy.next;
    }
    public NodeA copyRandomListWitExtraSpace(NodeA head) {
        // This is with the extra space
        Map<NodeA, NodeA> map = new HashMap<>();

        NodeA curr = head, newCurr = null;
        while (curr != null) {
            newCurr = new NodeA(curr.val);
            map.put(curr, newCurr);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            newCurr = map.get(curr);
            newCurr.next = map.get(curr.next);
            newCurr.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}

class NodeA {
    int val;
    NodeA next;
    NodeA random;

    public NodeA(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

