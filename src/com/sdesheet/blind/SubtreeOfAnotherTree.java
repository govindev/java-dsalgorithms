package com.sdesheet.blind;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSame(root, subRoot)) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode head1, TreeNode head2) {
        if (head1 == head2) {
            return true;
        }
        if (head1 == null || head2 == null || head1.val != head2.val) {
            return false;
        }
        return isSame(head1.left, head2.left) && isSame(head1.right, head2.right);
    }
}
