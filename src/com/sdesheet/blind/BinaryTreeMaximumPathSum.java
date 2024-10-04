package com.sdesheet.blind;

public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maximumPathSum(root);
        return max;
    }

    private int maximumPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int current = root.val;
        int leftSum = maximumPathSum(root.left);
        int rightSum = maximumPathSum(root.right);

        max = Math.max(max, current);
        max = Math.max(max, current+leftSum);
        max = Math.max(max, current+rightSum);
        max = Math.max(max, current+leftSum+rightSum);

        return Math.max(current, Math.max(current+leftSum, current+rightSum));
    }

}
