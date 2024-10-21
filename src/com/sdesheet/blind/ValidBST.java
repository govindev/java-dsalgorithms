package com.sdesheet.blind;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long start, long end) {
        return (root == null)
                || ((root.val > start && root.val < end)
                && (isValidBST(root.left, start, root.val))
                && (isValidBST(root.right, root.val, end)));
    }
}
