package com.sdesheet.blind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        int len = preorder.length;
        return buildTree(preorder, 0, len-1, inorder, 0, len-1);
    }

    private TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        int rootVal = preorder[pStart];
        // Find the rootVal in the inorder
        int inOrderRootInd = iStart;
        for (; inOrderRootInd <= iEnd; inOrderRootInd++) {
            if (rootVal == inorder[inOrderRootInd]) {
                // Found
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        // Left tree number of elements
        int leftTreeLen = (inOrderRootInd-iStart);
        // Right tree number of elements
        int rightTreeLen = (iEnd-inOrderRootInd);

        root.left = buildTree(preorder, pStart+1, pStart+leftTreeLen,
                inorder, iStart, inOrderRootInd-1);
        root.right = buildTree(preorder, pStart+leftTreeLen+1, pStart+leftTreeLen+rightTreeLen,
                inorder, inOrderRootInd+1, iEnd);
        return root;
    }
}
