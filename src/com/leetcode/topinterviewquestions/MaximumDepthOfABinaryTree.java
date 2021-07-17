package com.leetcode.topinterviewquestions;

class TreeNodeG {
	int val;
	TreeNodeG left;
	TreeNodeG right;

	TreeNodeG() {
	}

	TreeNodeG(int val) {
		this.val = val;
	}

	TreeNodeG(int val, TreeNodeG left, TreeNodeG right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class MaximumDepthOfABinaryTree {
	public int maxDepth(TreeNodeG root) {
		return maxDepth(root, 0);
	}

	public int maxDepth(TreeNodeG root, int depth) {
		if (root == null)
			return depth;
		return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
	}
}
