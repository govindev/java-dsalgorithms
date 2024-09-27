package com.sdesheet.blind;

import java.util.Arrays;

public class ConstructTreeWithPreorderAndInorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // return buildTreeExtraSpace(preorder, inorder);
        Map<Integer, Integer> elmIndexes = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            elmIndexes.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, elmIndexes, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, Map<Integer, Integer> elmIndexes,
                              int poStart, int poEnd, int ioStart, int ioEnd) {
        if (poStart > poEnd || ioStart > ioEnd) {
            return null;
        }
        if (poStart == poEnd) {
            return new TreeNode(preorder[poStart]);
        }
        int root = preorder[poStart];
        int rootIndex = elmIndexes.get(root);
        int numberOfElms = (rootIndex-ioStart+1);

        TreeNode rootNode = new TreeNode(root);
        rootNode.left = buildTree(preorder, inorder, elmIndexes, poStart+1, poStart+numberOfElms-1, ioStart, rootIndex-1);
        rootNode.right = buildTree(preorder, inorder, elmIndexes, poStart+numberOfElms, poEnd, rootIndex+1, ioEnd);
        return rootNode;
    }

    public TreeNode buildTreeExtraSpace(int[] preorder, int[] inorder) {
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

        rootNode.left = buildTreeExtraSpace(leftPreorder, leftInorder);
        rootNode.right = buildTreeExtraSpace(rightPreorder, rightInorder);

        return rootNode;
    }

    private int[] leftArrayBefore(int[] array, int ind) {
        return Arrays.copyOfRange(array, 0, ind);
    }

    private int[] rightArrayAfter(int[] array, int ind) {
        return Arrays.copyOfRange(array, ind+1, array.length);
    }
}
