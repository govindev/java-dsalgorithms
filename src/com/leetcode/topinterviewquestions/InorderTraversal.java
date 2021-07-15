package com.leetcode.topinterviewquestions;

import java.util.*;

public class InorderTraversal {
	public List<Integer> inorderTraversal(TreeNodeB root) {
		return inorderTraversal(root, new ArrayList<>());
	}

	public List<Integer> inorderTraversal(TreeNodeB root, List<Integer> list) {
		if (root != null) {
			if (root.left != null) {
				list = inorderTraversal(root.left, list);
			}
			list.add(root.val);
			if (root.right != null) {
				list = inorderTraversal(root.right, list);
			}
		}
		return list;
	}
}

class TreeNodeB {
	int val;
	TreeNodeB left;
	TreeNodeB right;

	TreeNodeB() {
	}

	TreeNodeB(int val) {
		this.val = val;
	}

	TreeNodeB(int val, TreeNodeB left, TreeNodeB right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
