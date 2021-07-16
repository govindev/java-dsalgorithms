package com.leetcode.topinterviewquestions;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		Integer[] array = new Integer[] { 3, 9, 20, null, null, 15, 7 };
		TreeNodeE root = new TreeNodeE(array[0]);
		root.left = new TreeNodeE(9);
		TreeNodeE right = new TreeNodeE(20);
		right.left = new TreeNodeE(15);
		right.right = new TreeNodeE(7);
		root.right = right;
		levelOrder(root);
	}

	public static List<List<Integer>> levelOrder(TreeNodeE root) {
		// This is using a single queue
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;

		Queue<TreeNodeE> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> currentLevel = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNodeE current = queue.remove();
				currentLevel.add(current.val);
				if (current.left != null) {
					queue.add(current.left);
				}
				if (current.right != null) {
					queue.add(current.right);
				}
			}
			list.add(currentLevel);
		}
		return list;
	}

	public static List<List<Integer>> levelOrder2Qs(TreeNodeE root) {
		// This is using two queues approach
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;

		Queue<TreeNodeE> queue = new LinkedList<>();
		// add, remove, peek, size()
		queue.add(root);
		return levelOrder(queue, list);

	}

	public static List<List<Integer>> levelOrder(Queue<TreeNodeE> queue, List<List<Integer>> list) {
		// Take a temporary queue
		Queue<TreeNodeE> newQueue = new LinkedList<>();

		List<Integer> current = new ArrayList<>();
		while (queue.peek() != null) {
			TreeNodeE node = queue.remove();
			current.add(node.val);
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				newQueue.add(node.right);
			}
		}
		list.add(current);
		if (newQueue.size() < 1)
			return list;
		return levelOrder(newQueue, list);
	}
}

class TreeNodeE {
	int val;
	TreeNodeE left;
	TreeNodeE right;

	TreeNodeE() {
	}

	TreeNodeE(int val) {
		this.val = val;
	}

	TreeNodeE(int val, TreeNodeE left, TreeNodeE right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}