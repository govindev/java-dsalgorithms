package com.leetcode.topinterviewquestions;

//Definition for a Node.
class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
};

public class PopulatingNextRightPointersInEachNode {
	public Node connect(Node root) {
		// Logic is. Current's next will be parent's left or parent's right(if current
		// is same as parent's left).
		// Current node is in current level. Parent is in current_level-1
		// Here we are not using stack. So in order to remember the level we maintain
		// the currentHead.
		// In the successive iterations parent will be assigned to the currentHead and
		// currentHead is assigned to the next level starting node.

		if (root == null)
			return root;
		Node parent = root;
		Node currentHead, current;
		if (root.left != null) {
			currentHead = root.left;
			current = currentHead;
		} else if (root.right != null) {
			currentHead = root.right;
			current = currentHead;
		} else {
			return root;
		}

		while (parent != null) {
			// Set next to the current node
			while (parent != null) {
				if (parent.left != null && parent.left != current) {
					current.next = parent.left;
					current = current.next;
					continue;
				} else if (parent.right != null) {
					current.next = parent.right;
					parent = parent.next;
					current = current.next;
					continue;
				}
				break;
			}
			parent = currentHead;
			if (parent == null)
				break;
			if (parent.left != null) {
				currentHead = parent.left;
				current = currentHead;
			} else if (parent.right != null) {
				currentHead = parent.right;
				current = currentHead;
			} else {
				break;
			}
		}
		return root;
	}
}