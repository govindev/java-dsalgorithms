package com.challenges.gfg.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

/**
 * https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1
 * 
 * Given a Binary Tree, find diameter of it. +The diameter of a tree is the
 * number of nodes on the longest path between two leaves in the tree. The
 * diagram below shows two trees each with diameter nine, the leaves that form
 * the ends of a longest path are shaded (note that there is more than one path
 * in each tree of length nine, but no path longer than nine nodes).
 * 
 * 
 * 
 * Input Format: First line of input contains the number of test cases T. For
 * each test case, there will be only a single line of input which is a string
 * representing the tree as described below:
 * 
 * The values in the string are in the order of level order traversal of the
 * tree where, numbers denotes node values, and a character “N” denotes NULL
 * child.
 * 
 * For example:
 * 
 * For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N
 * 
 * Output Format: For each testcase, in a new line, print the diameter.
 * 
 * Your Task: You need to complete the function diameter() that takes node as
 * parameter and returns the diameter.
 * 
 * Constraints: 1 <= T <= 100 1 <= Number of nodes <= 10000 1 <= Data of a node
 * <= 1000
 * 
 * Example: Input: 2 1 2 3 10 20 30 40 60
 * 
 * Output: 3 4
 * 
 * Explanation: Testcase1: The tree is 1 / \ 2 3 The diameter is of 3 length.
 * Testcase2: The tree is 10 / \ 20 30 / \ 40 60 The diameter is of 4 length.
 * 
 * @author Govind
 *
 */

class DNode {
	int data;
	DNode left;
	DNode right;

	DNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class DiameterOfBinaryTree {
	static DNode buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		DNode root = new DNode(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<DNode> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			DNode currDNode = queue.peek();
			queue.remove();

			// Get the current DNode's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current DNode
				currDNode.left = new DNode(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currDNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current DNode
				currDNode.right = new DNode(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currDNode.right);
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
			DNode root = buildTree(s);

			DiameterOfATreeHelper g = new DiameterOfATreeHelper();
			System.out.println(g.maxPathSum(root));
		}
	}
}

//} Driver Code Ends
class DiameterOfATreeHelper {

	public static int maxPathSum(DNode root) {
		// Find out the highest diameter first
		return diameter(root);
	}

	public static int diameter(DNode root) {
		if (root == null)
			return 0;
		int lheight = findHeight(root.left);
		int rheight = findHeight(root.right);
		int diameter = lheight + rheight + 1;
		int leftDiameter = diameter(root.left);
		int rightDiameter = diameter(root.right);
		return max(diameter, max(leftDiameter, rightDiameter));
	}

	static int max(int a, int b) {
		if (a > b)
			return a;
		return b;
	}

	static int height = 0;

	private static int findHeight(DNode root) {
		height = 0;
		if (root == null)
			return 0;
		else {
			findHeight(root, 0);
			return height;
		}
	}

	private static int findHeight(DNode root, int level) {
		if (root != null) {
			findHeight(root.left, level + 1);
			findHeight(root.right, level + 1);
			if (level + 1 > height) {
				height = level + 1;
			}
		}
		return height;
	}
}
