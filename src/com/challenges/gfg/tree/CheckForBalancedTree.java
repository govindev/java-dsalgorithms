package com.challenges.gfg.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

/**
 * Given a binary tree, find if it is height balanced or not. A tree is height
 * balanced if difference between heights of left and right subtrees is not more
 * than one for all nodes of tree.
 * 
 * A height balanced tree 1 / \ 10 39 / 5
 * 
 * An unbalanced tree 1 / 10 / 5
 * 
 * Input: First line of input contains the number of test cases T. For each test
 * case, there will be only a single line of input which is a string
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
 * Output: For each testcase, in a new line, print 0 or 1 accordingly.
 * 
 * Your Task: You don't need to take input. Just complete the function
 * isBalanced() that takes root node as parameter and returns true, if the tree
 * is balanced else returns false.
 * 
 * Constraints: 1 <= T <= 100 1 <= Number of nodes <= 105 0 <= Data of a node <=
 * 106
 * 
 * Example: Input: 3 1 2 N N 3 10 20 30 40 60 N N 4 6 6 Output: 0 1 1
 * Explanation: Testcase1: The tree is 1 / 2 \ 3 The max difference in height of
 * left subtree and right subtree is 2, which is greater than 1. Hence
 * unbalanced. Testcase2: The tree is 10 / \ 20 30 / \ 40 60 The max difference
 * in height of left subtree and right subtree is 1. Hence balanced.
 * 
 * @author Govind
 *
 */
class FNode {
	int data;
	FNode left;
	FNode right;

	FNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class CheckForBalancedTree {

	static FNode buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		FNode root = new FNode(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<FNode> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			FNode currFNode = queue.peek();
			queue.remove();

			// Get the current FNode's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current FNode
				currFNode.left = new FNode(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currFNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current FNode
				currFNode.right = new FNode(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currFNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(FNode root) {
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
			FNode root = buildTree(s);
			Tree2 g = new Tree2();

			if (g.isBalanced(root) == true)
				System.out.println(1);
			else
				System.out.println(0);
			t--;

		}
	}

}

class Tree2 {

	/*
	 * This function should return tree if passed tree is balanced, else false.
	 */
	boolean isBalanced(FNode root) {
		return (height(root) != -1) ? true : false;
	}

	int height(FNode FNode) {
		if (FNode == null)
			return 0;
		int leftHeight = height(FNode.left);
		int rightHeight = height(FNode.right);
		if (leftHeight == -1 || rightHeight == -1) {
			// either left or right subtrees are unbalanced
			return -1;
		}
		if (leftHeight - rightHeight > 1 || rightHeight - leftHeight > 1) {
			return -1;
		} else {
			return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
		}
	}
}
