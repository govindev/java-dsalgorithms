package com.sdesheet.blind;

public class LcaOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode leftLca = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLca = lowestCommonAncestor(root.right, p, q);
        if (leftLca != null && rightLca != null) {
            return root;
        }
        if (leftLca != null) {
            return leftLca;
        }
        if (rightLca != null) {
            return rightLca;
        }
        return null;
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
