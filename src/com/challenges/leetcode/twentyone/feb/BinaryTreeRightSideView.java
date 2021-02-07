package com.challenges.leetcode.twentyone.feb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3630/
 * 
 * @author Govind
 *
 */
public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode1 root) {
		List<Integer> visibleVals = new ArrayList<>();
		if (root == null)
			return visibleVals;

		Queue<TreeNode1> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode1 current = queue.remove();
				if (i == size - 1) {
					visibleVals.add(current.val);
				}
				if (current.left != null) {
					queue.add(current.left);
				}
				if (current.right != null) {
					queue.add(current.right);
				}
			}
		}
		return visibleVals;
	}
}

class TreeNode1 {
	int val;
	TreeNode1 left;
	TreeNode1 right;

	TreeNode1() {
	};

	TreeNode1(int val) {
		this.val = val;
	}

	TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}