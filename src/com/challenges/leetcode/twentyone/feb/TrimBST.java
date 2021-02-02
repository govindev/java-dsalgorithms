package com.challenges.leetcode.twentyone.feb;

/**
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3626/
 * 
 * @author Govind
 *
 */
public class TrimBST {
	public static void main(String[] args) {
	}

	public TreeNode trimBST(TreeNode root, int low, int high) {
		if (root == null)
			return null;
		if (root.val < low) {
			return trimBST(root.right, low, high);
		} else if (root.val > high) {
			return trimBST(root.left, low, high);
		}
		root.left = trimBST(root.left, low, high);
		root.right = trimBST(root.right, low, high);
		return root;
	}
}

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
