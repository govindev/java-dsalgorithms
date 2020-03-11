package com.challenges.gfg.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

/**
 * Given a binary tree, connect the nodes that are at same level. Structure of
 * the given Binary Tree node is like following.
 * 
 * struct Node { int data; Node* left; Node* right; Node* nextRight; }
 * Initially, all the nextRight pointers point to garbage values. Your function
 * should set these pointers to point next right for each node. 10 10 ------>
 * NULL / \ / \ 3 5 => 3 ------> 5 --------> NULL / \ \ / \ \ 4 1 2 4 --> 1
 * -----> 2 -------> NULL
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
 * Output Format: For each testcase, in a new line, print the level order and
 * inorder traversals.
 * 
 * Your Task: You don't have to take input. Complete the function connect() that
 * takes node as parameter and connects the nodes at same level. The printing is
 * done by the driver code.
 * 
 * Constraints: 1 <= T <= 100 1 <= Number of nodes <= 100 1 <= Data of a node <=
 * 1000
 * 
 * Example: Input: 2 3 1 2 10 20 30 40 60 Output: 3 1 2 1 3 2 10 20 30 40 60 40
 * 20 60 10 30
 * 
 * Explanation: Testcase1: The connected tree is 3 ------> NULL / \ 1 -----> 2
 * ------ NULL Testcase2: The connected tree is 10 ----------> NULL / \ 20
 * ------> 30 -------> NULL / \ 40 ----> 60 ----------> NULL
 * 
 * @author Govind
 *
 */
class NRNode {
	int data;
	NRNode left;
	NRNode right;
	NRNode nextRight;

	NRNode(int data) {
		this.data = data;
		left = null;
		right = null;
		nextRight = null;
	}
}

class ConnectNodesAtSameLevel {

	static NRNode buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		NRNode root = new NRNode(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<NRNode> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			NRNode currNRNode = queue.peek();
			queue.remove();

			// Get the current NRNode's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current NRNode
				currNRNode.left = new NRNode(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNRNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current NRNode
				currNRNode.right = new NRNode(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNRNode.right);
			}
			i++;
		}

		return root;
	}

	public static void printInorder(NRNode root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void printSpecial(NRNode root) {
		if (root == null)
			return;

		NRNode next_root = null;

		while (root != null) {
			System.out.print(root.data + " ");

			if (root.left != null && next_root == null)
				next_root = root.left;
			else if (root.right != null && next_root == null)
				next_root = root.right;

			root = root.nextRight;
		}

		printSpecial(next_root);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			NRNode root = buildTree(s);
			Tree1 g = new Tree1();
			g.connect(root);
			printSpecial(root);
			System.out.println();
			printInorder(root);
			System.out.println();
			t--;

		}
	}

}

class Tree1 {
	public static void connect(NRNode p) {
		Queue<NRNode> q = new LinkedList<NRNode>();
		q.add(p);
		while (!q.isEmpty()) {
			int c = q.size();
			for (int i = 0; i < c; i++) {
				NRNode node = q.poll();
				if (i != c - 1) {
					node.nextRight = q.peek();
				} else {
					node.nextRight = null;
				}
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
		}
	}

	public static void connect1(NRNode p) {
		Queue<NRNode> q1 = new LinkedList<NRNode>();
		Queue<NRNode> q2 = new LinkedList<NRNode>();
		if (p != null)
			q1.add(p);
		while (!q1.isEmpty() || !q2.isEmpty()) {
			NRNode prevNRNode = null;
			while (!q1.isEmpty()) {
				NRNode q1NRNode = q1.remove();
				if (q1NRNode.left != null) {
					q2.add(q1NRNode.left);
					if (prevNRNode != null) {
						prevNRNode.nextRight = q1NRNode.left;
					}
					prevNRNode = q1NRNode.left;
				}
				if (q1NRNode.right != null) {
					q2.add(q1NRNode.right);
					if (prevNRNode != null) {
						prevNRNode.nextRight = q1NRNode.right;
					}
					prevNRNode = q1NRNode.right;
				}
			}
			prevNRNode = null;
			while (!q2.isEmpty()) {
				NRNode q2NRNode = q2.remove();
				if (q2NRNode.left != null) {
					q1.add(q2NRNode.left);
					if (prevNRNode != null) {
						prevNRNode.nextRight = q2NRNode.left;
					}
					prevNRNode = q2NRNode.left;
				}
				if (q2NRNode.right != null) {
					q1.add(q2NRNode.right);
					if (prevNRNode != null) {
						prevNRNode.nextRight = q2NRNode.right;
					}
					prevNRNode = q2NRNode.right;
				}
			}
		}
	}
}