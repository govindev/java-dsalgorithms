package com.challenges.gfg.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

/**
 * https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1
 * 
 * Given two binary trees, the task is to find if both of them are identical or
 * not.
 * 
 * Input:
 * 
 * First line of input contains the number of test cases T. For each test case,
 * there will be two lines of input each of which is a string representing the
 * tree as described below:
 * 
 * The values in the string are in the order of level order traversal of the
 * tree where, numbers denotes node values, and a character “N” denotes NULL
 * child.
 * 
 * For example:
 * 
 * 
 * 
 * For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N Output: The
 * function should return true if both trees are identical else false.
 * 
 * User task: Since this is a functional problem you don't have to worry about
 * input, you just have to complete the function isIdentical() that takes two
 * roots as parameters and returns true or false. The printing is done by the
 * driver code.
 * 
 * Constraints: 1 <= T <= 100 1 <= Number of nodes <= 100 1 <=Data of a node <=
 * 1000
 * 
 * Example: Input: 3 1 2 3 1 2 3 1 2 3 1 3 2 1 2 3 N 3 N 10 1 2 3 N 3 N 10
 * Output Yes No Yes
 * 
 * Explanation: Testcase 1: There are two trees both having 3 nodes and 2 edges,
 * both trees are identical having the root as 1, left child of 1 is 2 and right
 * child of 1 is 3. Testcase 2: There are two trees both having 3 nodes and 2
 * edges, but both trees are not identical.
 * 
 * @author Govind
 *
 */
class ANode {
	int data;
	ANode left;
	ANode right;

	ANode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class DeterminIfTwoATreesAreIdentical {

	static ANode buildATree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the ATree
		ANode root = new ANode(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<ANode> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			ANode currANode = queue.peek();
			queue.remove();

			// Get the current ANode's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current ANode
				currANode.left = new ANode(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currANode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current ANode
				currANode.right = new ANode(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currANode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(ANode root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String s1 = br.readLine();
			String s2 = br.readLine();
			ANode root1 = buildATree(s1);
			ANode root2 = buildATree(s2);
			ATree g = new ATree();
			// System.out.println(g.isIdentical(root,roott));
			boolean b = g.isIdentical(root1, root2);
			if (b == true)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}

/*
 * Should return true if ATrees with roots as root1 and root2 are identical
 */

class ATree {
	boolean isIdentical(ANode root1, ANode root2) {
		if (root1 != null && root2 == null)
			return false;
		if (root1 == null && root2 != null)
			return false;
		if (root1 != null) {
			if (root1.data != root2.data)
				return false;
			if (!isIdentical(root1.left, root2.left))
				return false;
			if (!isIdentical(root1.right, root2.right))
				return false;
		}
		return true;
	}

}