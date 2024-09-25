package com.sdesheet.blind;

public class LcaOfBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // return lowestCommonAncestorRecursive(root, p, q);
        return lowestCommonAncestorIterative(root, p, q);
    }

    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p) {
            return p;
        }
        if (root == q) {
            return q;
        }
        if (root.val > p.val  && root.val > q.val) {
            return lowestCommonAncestorRecursive(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestorRecursive(root.right, p, q);
        }
        return root;
    }
    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val > root.val && q.val > root.val) root = root.right;
            else if (p.val < root.val && q.val < root.val) root = root.left;
            else return root;
        }
        return root;
    }
}
