package com.challenges.leetcode.twentyone.feb;

/***
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3634/
 * 
 * @author Govind
 *
 */
public class ConvertBSTToGreaterTree {
	int sum;

	public TreeNode2 convertBST(TreeNode2 root) {
		if (root == null)
			return null;
		convertBST(root.right);
		sum += root.val;
		root.val = sum;
		convertBST(root.left);
		return root;

	}
}

// Definition for a binary tree node.
class TreeNode2 {
	int val;
	TreeNode2 left;
	TreeNode2 right;

	TreeNode2() {
	};

	TreeNode2(int val) {
		this.val = val;
	}

	TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}