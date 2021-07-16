package com.leetcode.topinterviewquestions;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNodeF root) {
		List<List<Integer>> list = new ArrayList<>();
		Queue<TreeNodeF> queue = new LinkedList<>();
		if (root == null)
			return list;

		queue.add(root);
		boolean reverse = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> currentLevel = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNodeF current = queue.remove();
				if (reverse)
					currentLevel.add(0, current.val);
				else
					currentLevel.add(current.val);
				if (current.left != null) {
					queue.add(current.left);
				}
				if (current.right != null) {
					queue.add(current.right);
				}
			}
			// if (reverse) {
			// Collections.reverse(currentLevel);
			// }
			reverse = !reverse;
			list.add(currentLevel);
		}
		return list;
	}
}

class TreeNodeF {
	int val;
	TreeNodeF left;
	TreeNodeF right;

	TreeNodeF() {
	}

	TreeNodeF(int val) {
		this.val = val;
	}

	TreeNodeF(int val, TreeNodeF left, TreeNodeF right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}