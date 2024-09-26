package com.sdesheet.blind;

import java.util.Arrays;

public class ConstructTreeWithPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                rootIndex = i;
                break;
            }
        }

        TreeNode rootNode = new TreeNode(preorder[0]);

        int[] leftInorder = leftArrayBefore(inorder, rootIndex);
        int[] rightInorder = rightArrayAfter(inorder, rootIndex);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftInorder.length+1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, leftInorder.length+1, preorder.length);

        rootNode.left = buildTree(leftPreorder, leftInorder);
        rootNode.right = buildTree(rightPreorder, rightInorder);

        return rootNode;
    }

    private int[] leftArrayBefore(int[] array, int ind) {
        return Arrays.copyOfRange(array, 0, ind);
    }

    private int[] rightArrayAfter(int[] array, int ind) {
        return Arrays.copyOfRange(array, ind+1, array.length);
    }
}
