package com.challenges.gfg.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

/**
 * https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1
 * 
 * Given a binary tree, find height of it.
 * 
 * 1 / \ 10 39 / 5 The above tree has a height of 3. Note: Height of empty tree
 * is considered 0.
 * 
 * Input Format: First line of input contains the number of test cases T. For
 * each test case, there will be only a single line of input which is a string
 * representing the tree as described below:
 * 
 * The values in the string are in the order of level order traversal of the
 * tree where, numbers denote node values, and a character “N” denotes NULL
 * child.
 * 
 * For example:
 * 
 * For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N
 * 
 * Output Format: For each testcase, in a new line, print the height of tree.
 * 
 * Your Task: You don't have to take input. Complete the function height() that
 * takes node as parameter and returns the height. The printing is done by the
 * driver code.
 * 
 * Constraints: 1 <= T <= 100 1 <= Number of nodes <= 105 1 <= Data of a node <=
 * 105 Sum of N over all testcases doesn't exceed 105
 * 
 * Example: Input: 3 1 2 3 2 N 1 3 N 10 20 30 40 60 N N Output: 2 3 3
 * Explanation: Testcase1: The tree is 1 / \ 2 3 So, the height would be 2.
 * Testcase2: The tree is 2 \ 1 / 3 So, height would be 3. Testcase3: The tree
 * is
 * 
 * 10 / \ 20 30 / \ 40 60
 * 
 * So, height would be 3.
 * 
 * @author Govind
 *
 */

class CNode {
	int data;
	CNode left;
	CNode right;

	CNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class HeightOfBinaryTree {

	static CNode buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		CNode root = new CNode(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<CNode> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			CNode currCNode = queue.peek();
			queue.remove();

			// Get the current CNode's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current CNode
				currCNode.left = new CNode(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currCNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current CNode
				currCNode.right = new CNode(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currCNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(CNode root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			CNode root = buildTree(s);

			HeightOfBinaryTreeHelper g = new HeightOfBinaryTreeHelper();
			System.out.println(g.height(root));
			t--;

		}
	}
}

/*
 * A Binary Tree CNode
 * 
 * class CNode { int data; CNode left, right;
 * 
 * CNode(int item) { data = item; left = right = null; } }
 */

class HeightOfBinaryTreeHelper {
	static int height = 0;

	int height(CNode CNode) {
		height = 0;
		find(CNode, 0);
		return height;
	}

	void find(CNode CNode, int level) {
		if (CNode != null) {
			int temp = level + 1;
			if (temp > height) {
				height = temp;
			}
			find(CNode.left, temp);
			find(CNode.right, temp);
		}
	}
}
