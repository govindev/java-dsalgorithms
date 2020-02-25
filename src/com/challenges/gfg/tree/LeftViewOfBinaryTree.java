package com.challenges.gfg.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

/**
 * https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
 * 
 * Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set
 * of nodes visible when tree is visited from Left side. The task is to complete
 * the function leftView(), which accepts root of the tree as argument.
 * 
 * Left view of following tree is 1 2 4 8.
 * 
 * 1 / \ 2 3 / \ / \ 4 5 6 7 \ 8
 * 
 * Input: The first line of input contains the number of test cases T. For every
 * test case, the first line of input contains two space-separated integers,
 * denoting node values for which we want to find LCA, and the second line will
 * contain a string representing the tree as described below:
 * 
 * The values in the string are in the order of level order traversal of the
 * tree where, numbers denote node values, and a character “N” denotes NULL
 * child.
 * 
 * For example:
 * 
 * 
 * For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N
 * 
 * Output: The function should print nodes in left view of Binary Tree.
 * 
 * User Task: Since this is a functional problem you don't have to worry about
 * input, you just have to complete the function leftView() that prints the left
 * view. The newline is automatically appended by the driver code.
 * 
 * Constraints: 1 <= T <= 100 1 <= Number of nodes <= 100 1 <= Data of a node <=
 * 1000
 * 
 * Example: Input: 2 1 3 2 10 20 30 40 60 N N Output: 1 3 10 20 40
 * 
 * Explanation: Testcase 2: below is a given tree with its nodes.
 * 
 * We can clearly see that nodes which are at left view of tree they are 10 20
 * 40.
 * 
 * 
 * Note: The Input/Output format and Example given are used for the system's
 * internal purpose, and should be used by a user for Expected Output only. As
 * it is a function problem, hence a user should not read any input from the
 * stdin/console. The task is to complete the function specified, and not to
 * write the full code.
 * 
 * @author Govind
 *
 */
class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class LeftViewOfBinaryTree {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
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
			Node root = buildTree(s);
			Tree g = new Tree();
			g.leftView(root);
			System.out.println();
			t--;
		}
	}
}

class Tree {
	void leftView(Node root) {
		StringBuilder output = new StringBuilder();
		Node current = root;
		while (current != null) {
			output.append(current.data + " ");
			if (current.left != null)
				current = current.left;
			else
				current = current.right;
		}
		System.out.print(output);
	}
}