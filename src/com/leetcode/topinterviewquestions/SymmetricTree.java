package com.leetcode.topinterviewquestions;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class SymmetricTree {
	StringBuilder sb;

	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root.left, root.right);
	}

	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		if (left.val == right.val) {
			return (isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left));
		}
		return false;
	}

	public boolean isSymmetricNaive(TreeNode root) {
		// Works for a fully balanced tree only
		sb = new StringBuilder();
		inorder(root);
		String s = sb.toString();
		System.out.println(s);
		if (s != null && s.equals(sb.reverse().toString())) {
			return true;
		}
		return false;
	}

	public void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right != null) {
			sb.append("p");
		} else {
			inorder(root.left);
		}
		sb.append(root.val);
		if (root.right == null && root.left != null) {
			sb.append("p");
		} else {
			inorder(root.right);
		}

	}
}