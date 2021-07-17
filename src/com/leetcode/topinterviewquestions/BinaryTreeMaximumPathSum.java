package com.leetcode.topinterviewquestions;

import java.util.*;

//public class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode() {
//	}
//
//	TreeNode(int val) {
//		this.val = val;
//	}
//
//	TreeNode(int val, TreeNode left, TreeNode right) {
//		this.val = val;
//		this.left = left;
//		this.right = right;
//	}
//}

public class BinaryTreeMaximumPathSum {
	int answer = Integer.MIN_VALUE;

	public int dfs(TreeNode root) {
		if (root == null)
			return 0;
		int x = dfs(root.left);
		int y = dfs(root.right);
		answer = Math.max(answer, x + y + root.val);
		return Math.max(0, root.val + Math.max(x, y));
	}

	public int maxPathSum(TreeNode root) {
		dfs(root);
		return answer;
	}

	// IGNORE
	public int maxPathSumInorderArray(TreeNode root) {
		// This solution prepares the inorder array and gets the max sum of the array
		if (root == null)
			return 0;
		List<Integer> list = new ArrayList<>();
		inorder(root, list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ", ");
		}
		if (list.size() == 1)
			return list.get(0);
		int maxPathSum = list.get(0), prevSum = list.get(0);
		int left = 0, right = 1;
		while (left < right && right < list.size()) {
			int sum = prevSum + list.get(right);
			if (sum < list.get(right)) {
				left = right;
				prevSum = list.get(right);
				right++;
			} else if (sum <= 0) {
				// This is the breaking condition
				left = right + 1;
				if (left >= list.size())
					break;
				prevSum = list.get(left);
				right += 2;
			} else {
				prevSum = sum;
				right++;
			}
			maxPathSum = maxPathSum > prevSum ? maxPathSum : prevSum;
		}
		return maxPathSum;
	}

	public void inorder(TreeNode node, List<Integer> list) {
		if (node == null)
			return;
		inorder(node.left, list);
		list.add(node.val);
		inorder(node.right, list);
	}
}