package com.sdesheet.blind;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeABinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if (current != null) {
                sb.append(current.val);
                queue.add(current.left);
                queue.add(current.right);
            } else {
                sb.append("n");
            }
            sb.append(",");
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }
        String[] vals = data.split(",");

        if (vals.length == 0) {
            return null;
        }

        Integer rootVal = Integer.parseInt(vals[0]);
        TreeNode root = new TreeNode(rootVal);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if (current == null) {
                continue;
            }
            current.left = getNode(vals[i++]);
            current.right = getNode(vals[i++]);
            queue.add(current.left);
            queue.add(current.right);
        }

        return root;
    }

    private TreeNode getNode(String valStr) {
        if (valStr == null || valStr.equals("n")) {
            return null;
        }
        Integer val = Integer.parseInt(valStr);
        return new TreeNode(val);
    }
}
