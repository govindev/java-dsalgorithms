package com.sdesheet.blind;

public class KthSmallestElementInBST {
    int ind;
    public int kthSmallest(TreeNode root, int k) {
        ind = 0;
        return dfs(root, k).val;
    }
    private TreeNode dfs(TreeNode root, int k) {
        if (root == null) {
            return root;
        }
        TreeNode res = dfs(root.left, k);
        if (res != null) {
            return res;
        }
        ind++;
        if (ind == k) {
            return root;
        }
        return dfs(root.right, k);
    }
}
