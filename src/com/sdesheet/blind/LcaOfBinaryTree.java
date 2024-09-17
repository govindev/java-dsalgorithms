package com.sdesheet.blind;

public class LcaOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p) return p;
        if (root == q) return q;
        if (root == null) return null;

        TreeNode leftAncestor = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAncestor = lowestCommonAncestor(root.right, p, q);

        if (leftAncestor != null && rightAncestor != null) return root;
        if (leftAncestor == null) return rightAncestor;
        else return leftAncestor;
    }

    public TreeNode lowestCommonAncestorBruteForce(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode leftAncestor = lowestCommonAncestorBruteForce(root.left, p, q);
        if (leftAncestor != null) return leftAncestor;
        TreeNode rightAncestor = lowestCommonAncestorBruteForce(root.right, p, q);
        if (rightAncestor != null) return rightAncestor;

        return (found(root, p) && found(root, q)) ? root : null;
    }

    private boolean found(TreeNode root, TreeNode key) {
        if (root == null) return false;
        if (root.val == key.val) return true;
        return found(root.left, key) || found(root.right, key);
    }
}
