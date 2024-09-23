package com.sdesheet.blind;

public class KthSmallestElementInBST {
    int counter = 0;
    public int kthSmallest(TreeNode root, int k) {
        counter = 0;
        TreeNode smallest = kthSmallestNode(root, k);
        if (smallest != null) {
            return smallest.val;
        }
        return -1;
    }

    private TreeNode kthSmallestNode(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            TreeNode left = kthSmallestNode(root.left, k);
            if (left != null) {
                return left;
            }
        }
        counter++;
        if (k == counter) {
            return root;
        }
        return kthSmallestNode(root.right, k);
    }
}
