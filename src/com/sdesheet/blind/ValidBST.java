package com.sdesheet.blind;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long leftBoundary, long rightBoundary) {
        if (root == null) {
            return true;
        }
        if (leftBoundary >= root.val || root.val >= rightBoundary) return false;

        return isValidBST(root.left, leftBoundary, root.val) && isValidBST(root.right, root.val, rightBoundary);
    }
}
