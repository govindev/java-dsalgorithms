package com.leetcode.thirtydaychallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Diameter of Binary Tree
 * 
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3293/
 * 
 * Given a binary tree, you need to compute the length of the diameter of the
 * tree. The diameter of a binary tree is the length of the longest path between
 * any two nodes in a tree. This path may or may not pass through the root.
 * 
 * Example: Given a binary tree 1 / \ 2 3 / \ 4 5 Return 3, which is the length
 * of the path [4,2,1,3] or [5,2,1,3].
 * 
 * Note: The length of path between two nodes is represented by the number of
 * edges between them.
 * 
 * @author Govind
 *
 */
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	TreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class DiameterOfBinaryTree {
	static TreeNode buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			TreeNode currTreeNode = queue.peek();
			queue.remove();

			// Get the current TreeNode's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current TreeNode
				currTreeNode.left = new TreeNode(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currTreeNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current TreeNode
				currTreeNode.right = new TreeNode(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currTreeNode.right);
			}
			i++;
		}

		return root;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine().trim());

		while (t-- > 0) {
			String s = br.readLine().trim();
			TreeNode root = buildTree(s);

			DiameterOfBinaryTreeHelper g = new DiameterOfBinaryTreeHelper();
			System.out.println(g.diameterOfBinaryTree(root));
		}
	}
}

class DiameterOfBinaryTreeHelper {
	public int height(TreeNode node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		// Steps
		// 1. Find the height of the left tree
		int lHeight = height(node.left);
		// 2. Find the height of the right tree
		int rHeight = height(node.right);
		// 3. Find the Max
		return (lHeight > rHeight) ? lHeight + 1 : rHeight + 1;
	}

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		// Steps
		// 1. Find the height of the left sub tree
		int lHeight = height(root.left);
		// 2. Find the height of the right sub tree
		int rHeight = height(root.right);
		int diameter = lHeight + rHeight + 1;
		// 3. It can happen that Left trees / Right trees diameter is more
		int lDiameter = diameterOfBinaryTree(root.left);
		int rDiameter = diameterOfBinaryTree(root.right);
		int maxDiameter = (lDiameter > rDiameter) ? lDiameter : rDiameter;
		// Returning diameter - 1 because output should include the no of edges not the
		// no of nodes
		return (diameter > maxDiameter) ? diameter - 1 : maxDiameter;
	}
}
