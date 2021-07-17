package com.leetcode.topinterviewquestions;

import java.util.*;

//  public class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
//  }
public class ConstructBinaryTreeFromPreorderAndInorder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder.length == 1)
			return new TreeNode(inorder[0]);

		Map<Integer, Integer> positions = new HashMap<Integer, Integer>();
		for (int i = 0; i < preorder.length; i++) {
			positions.put(preorder[i], i);
		}

		int rootValue = preorder[0];
		int rootIndex = -1;
		for (int i = 0; i < inorder.length; i++) {
			if (rootValue == inorder[i]) {
				rootIndex = i;
			}
		}
		TreeNode root = new TreeNode(rootValue);
		root.left = buildTree(preorder, inorder, 0, rootIndex, positions);
		root.right = buildTree(preorder, inorder, rootIndex + 1, inorder.length, positions);
		return root;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder, int low, int high, Map<Integer, Integer> positions) {
		System.out.println("low : " + low + ", high : " + high);
		if (low >= high)
			return null;
		if (low == high - 1) {
			return new TreeNode(inorder[low]);
		}
		// Find the root
		// Check which element from the inorder subtree comes first in the preorder
		// array

		int rootIndex = high - 1;
		int pj = preorder.length - 1;
		for (int i = low; i < high; i++) {
			// for (int j = 0; j < preorder.length; j++) {
			// if (inorder[i] == preorder[j] && j < pj) {
			// pj = j;
			// rootIndex = i;
			// System.out.println("pj : " + pj + ", rootIndex : " + rootIndex);
			// }
			// }
			if (positions.get(inorder[i]) < pj) {
				pj = positions.get(inorder[i]);
				rootIndex = i;
			}

		}

		int rootValue = inorder[rootIndex];
		TreeNode root = new TreeNode(rootValue);
		root.left = buildTree(preorder, inorder, low, rootIndex, positions);
		root.right = buildTree(preorder, inorder, rootIndex + 1, high, positions);
		return root;
	}
}