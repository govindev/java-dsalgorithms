package com.sdesheet.blind;

import java.util.HashMap;
import java.util.Map;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, new HashMap<>());
    }

    public boolean isValidBST(TreeNode root, Map<TreeNode, int[]> boundaries) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            boundaries.put(root, new int[]{root.val, root.val});
            return true;
        }

        int leftsHighestVal = root.val;
        int rightsLowestVal = root.val;

        if (root.left != null && root.left.val <= root.val && isValidBST(root.left, boundaries)) {
            leftsHighestVal = boundaries.get(root.left)[1];
        } else {
            return false;
        }

        if (root.right != null && root.right.val >= root.val && isValidBST(root.right, boundaries)) {
            rightsLowestVal = boundaries.get(root.right)[0];
        } else {
            return false;
        }

        if (leftsHighestVal <= root.val && rightsLowestVal >= root.val) {
            boundaries.put(root, new int[] {leftsHighestVal, rightsLowestVal});
            return true;
        }
        return false;

    }
}
