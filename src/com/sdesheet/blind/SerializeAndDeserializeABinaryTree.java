package com.sdesheet.blind;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeABinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder str = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode top = queue.remove();
            if (top != null) {
                queue.add(top.left);
                queue.add(top.right);
                str.append(top.val);
            } else {
                str.append("null");
            }
            str.append(",");
        }
        str.deleteCharAt(str.length() - 1);
        // System.out.println("string is : " + str.toString());
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // System.out.println("received is : " + data);
        if (data.equals("")) {
            return null;
        }
        String[] strs = data.split(",");
        int val = Integer.parseInt(strs[0]);
        TreeNode root = new TreeNode(val);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < strs.length) {
            TreeNode current = queue.remove();
            String leftStr = strs[i];
            String rightStr = strs[i+1];

            if (leftStr.equals("null")) {
                current.left = null;
            } else {
                int leftVal = Integer.parseInt(leftStr);
                current.left = new TreeNode(leftVal);
                queue.add(current.left);
            }
            if (rightStr.equals("null")) {
                current.right = null;
            } else {
                int rightVal = Integer.parseInt(rightStr);
                current.right = new TreeNode(rightVal);
                queue.add(current.right);
            }

            i+=2;
        }
        return root;
    }
}
