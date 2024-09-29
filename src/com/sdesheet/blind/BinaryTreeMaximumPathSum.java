package com.sdesheet.blind;

public class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        currPathSum(root);
        return maxSum;
    }
    private int currPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = currPathSum(root.left);
        int rightMax = currPathSum(root.right);

        int current = root.val;
        maxSum = Math.max(current, maxSum);
        maxSum = Math.max(current+leftMax, maxSum);
        maxSum = Math.max(current+rightMax, maxSum);
        maxSum = Math.max(current+leftMax+rightMax, maxSum);
        return Math.max(current, Math.max(current+leftMax, current+rightMax));
    }
}
