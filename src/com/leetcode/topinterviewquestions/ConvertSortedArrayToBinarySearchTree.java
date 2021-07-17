package com.leetcode.topinterviewquestions;

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
public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		return constructSubTree(nums, 0, nums.length);
	}

	public TreeNode constructSubTree(int[] nums, int low, int high) {
		if (low >= high)
			return null;
		if (low == high - 1)
			return new TreeNode(nums[low]);
		int mid = (low + high) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = constructSubTree(nums, low, mid);
		node.right = constructSubTree(nums, mid + 1, high);
		return node;
	}
}