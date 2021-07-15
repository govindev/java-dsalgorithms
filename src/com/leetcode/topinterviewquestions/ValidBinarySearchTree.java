package com.leetcode.topinterviewquestions;

public class ValidBinarySearchTree {
	public boolean isValidBSTBrute(TreeNodeC root) {
		// This doesn't work. Because we are not checking the root with the last element
		// on the right or left
		// We are only checking with the direct child values
		if (root != null) {
			if (((root.left == null) || (root.left != null && root.left.val < root.val))
					&& ((root.right == null) || (root.right != null && root.right.val > root.val))) {
				if (!isValidBST(root.left))
					return false;
				if (!isValidBST(root.right))
					return false;
			} else {
				return false;
			}
		}
		return true;
	}

	Integer last = null;

	public boolean isValidBST(TreeNodeC root) {
		if (root != null) {
			if (!isValidBST(root.left)) {
				return false;
			}
			if (last == null || last < root.val) {
				last = root.val;
			} else {
				// Not a valid binary search tree
				return false;
			}
			if (!isValidBST(root.right)) {
				return false;
			}
		}
		return true;
	}

}

class TreeNodeC {
	int val;
	TreeNodeC left;
	TreeNodeC right;

	TreeNodeC() {
	}

	TreeNodeC(int val) {
		this.val = val;
	}

	TreeNodeC(int val, TreeNodeC left, TreeNodeC right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
