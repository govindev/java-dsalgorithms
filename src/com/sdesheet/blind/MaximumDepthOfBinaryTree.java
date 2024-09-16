package com.sdesheet.blind;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Integer.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
    }
}
