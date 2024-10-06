package com.sdesheet.blind;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeABinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if (current != null) {
                queue.add(current.left);
                queue.add(current.right);
                sb.append(current.val);
            } else {
                sb.append("n");
            }
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        TreeNode root = getNode(strs[0]);
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < strs.length; i++) {
            TreeNode current = queue.remove();
            current.left = getNode(strs[i++]);
            current.right = getNode(strs[i]);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return root;
    }


    private TreeNode getNode(String valStr) {
        if ("n".equals(valStr)) {
            return null;
        }
        int val = Integer.parseInt(valStr);
        return new TreeNode(val);
    }
}
