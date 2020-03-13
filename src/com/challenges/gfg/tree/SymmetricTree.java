package com.challenges.gfg.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

/**
 * https://practice.geeksforgeeks.org/problems/symmetric-tree/1
 * 
 * Given a Binary Tree of size N, your task is to complete the function
 * isSymettric(), that check whether a binary is Symmetric or not, i.e. the
 * binary tree is Mirror image of itself or not. For example: The following
 * binary tree is symmetric:
 * 
 * 1 / \ 2 2 / \ / \ 3 4 4 3
 * 
 * But the following is not:
 * 
 * 1 / \ 2 2 \ \ 3 3 Input: First line of input contains the number of test
 * cases T. For each test case, there will be only a single line of input which
 * is a string representing the tree as described below:
 * 
 * The values in the string are in the order of level order traversal of the
 * tree where, numbers denote node values, and a character “N” denotes NULL
 * child.
 * 
 * For example:
 * 
 * For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N
 * 
 * Output: For each test case the function should return a boolean value.
 * 
 * Constraints: 1<=T<=100 1<=N<=100
 * 
 * Example: Input: 3 5 1 1 2 N N 2 5 10 20 20 20 N 30 100 10 10 20 20 20 20
 * Output: True False True Explanation: TestCase 1:
 * 
 * 5 / \ 1 1 / \ 2 2 Tree is mirror image of itself i.e. tree is symmetric
 * 
 * TestCase 2:
 * 
 * 5 / \ 10 20 / \ \ 20 20 30 Tree is not mirror image of itself i.e. tree is
 * not symmetric
 * 
 * TestCase 3:
 * 
 * 100 / \ 10 10 / \ / \ 20 20 20 20 Tree is mirror image of itself i.e. tree is
 * symmetric
 * 
 * @author Govind
 *
 */
class BNode {
	int data;
	BNode left;
	BNode right;

	BNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class SymmetricTree {

	static BNode buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		BNode root = new BNode(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<BNode> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			BNode currBNode = queue.peek();
			queue.remove();

			// Get the current BNode's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current BNode
				currBNode.left = new BNode(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currBNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current BNode
				currBNode.right = new BNode(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currBNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(BNode root) {
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
			BNode root = buildTree(s);

			SymmetricTreeHelper g = new SymmetricTreeHelper();
			if (g.isSymmetric(root) == true)
				System.out.println("True");
			else
				System.out.println("False");

			t--;

		}
	}
}

class SymmetricTreeHelper {
	public static boolean isSymmetric(BNode root) {
		if (root != null) {
			return isReflective(root.left, root.right);
		}
		return true;
	}

	public static boolean isReflective(BNode lefts, BNode rights) {
		if (lefts == null && rights == null)
			return true;
		if (lefts != null && rights != null) {
			if (lefts.data == rights.data) {
				return (isReflective(lefts.left, rights.right) && isReflective(lefts.right, rights.left));
			} else {
				return false;
			}
		}
		return false;
	}
}