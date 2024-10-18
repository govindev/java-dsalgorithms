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
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
	}
}
