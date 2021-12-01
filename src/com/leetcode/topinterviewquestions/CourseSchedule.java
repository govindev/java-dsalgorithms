package com.leetcode.topinterviewquestions;

import java.util.HashMap;
import java.util.Map;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> nodes = new HashMap<>();
        for (int[] pair: prerequisites) {
            int next = pair[0];
            int first = pair[1];

            if (nodes.containsKey(next)) return false;

            Node nextNode = new Node(next,null);
            nodes.put(next, nextNode);

            Node firstNode = new Node(first, nextNode);
            nodes.put(first, firstNode);

        }
        return true;
    }

    class Node {
        private int value;
        private Node next;
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }
}


