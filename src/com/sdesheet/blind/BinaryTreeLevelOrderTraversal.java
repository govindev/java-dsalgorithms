package com.sdesheet.blind;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        // levelOrder(root, levels, 0);
        levelOrderIterative(root, levels);
        return levels;
    }

    public void levelOrder(TreeNode curr, List<List<Integer>> levelsList, int level) {
        if (curr == null) return;
        if (levelsList.size() == level) {
            levelsList.add(new ArrayList<>());
        }

        List<Integer> levelNums = levelsList.get(level);
        levelNums.add(curr.val);

        levelOrder(curr.left, levelsList, level+1);
        levelOrder(curr.right, levelsList, level+1);
    }

    public void levelOrderIterative(TreeNode root, List<List<Integer>> levels) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levels.add(level);
        }
    }
}