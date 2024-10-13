package com.sdesheet.blind;

public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPath(root);
        return max;
    }

    private int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int current = root.val;
        int leftMaxPathSum = maxPath(root.left);
        int rightMaxPathSum = maxPath(root.right);

        max = Math.max(max, current);
        max = Math.max(max, current + leftMaxPathSum);
        max = Math.max(max, current + rightMaxPathSum);
        max = Math.max(max, current + leftMaxPathSum + rightMaxPathSum);

        return Math.max(current, Math.max(current + leftMaxPathSum, current + rightMaxPathSum));
    }
}
