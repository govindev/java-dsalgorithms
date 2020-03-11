package com.challenges.gfg.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

/**
 * Complete the function to print spiral order traversal of a tree. For below
 * tree, function should print 1, 2, 3, 4, 5, 6, 7.
 * 
 * 
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
 * Output Format: The function should print level order traversal in spiral
 * form.
 * 
 * Your Task: The task is to complete the function printSpiral() which prints
 * the elements in spiral form of level order traversal. The newline is
 * automatically appended by the driver code.
 * 
 * Constraints: 1 <= T <= 30 1 <= Number of nodes <= 105 1 <= Data of a node <=
 * 105
 * 
 * Example: Input: 2 1 3 2 10 20 30 40 60 Output: 1 3 2 10 20 30 60 40
 * 
 * Explanation: Testcase1: The tree is 1 / \ 3 2 So, the spiral level order
 * would be 1 3 2 Testcase2: The tree is 10 / \ 20 30 / \ 40 60 So, the spiral
 * level order would be 10 20 30 60 40
 * 
 * @author Govind
 *
 */

//class Node {
//	int data;
//	Node left;
//	Node right;
//
//	Node(int data) {
//		this.data = data;
//		left = null;
//		right = null;
//	}
//}

class LevelOrderTraversalInSpiralForm {

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

	void inOrder(Node node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.data + " ");

		inOrder(node.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String s = br.readLine();
			Node root = buildTree(s);
			Spiral g = new Spiral();
			g.printSpiral(root);
			System.out.println();

		}
	}
}

class Spiral {
	StringBuilder output = new StringBuilder();
	Stack<Node> s1 = new Stack<Node>();
	Stack<Node> s2 = new Stack<Node>();

	void printSpiral(Node node) {
		if (node != null)
			s1.push(node);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				Node s1Node = s1.pop();
				output.append(s1Node.data + " ");
				if (s1Node.right != null)
					s2.push(s1Node.right);
				if (s1Node.left != null)
					s2.push(s1Node.left);
			}
			while (!s2.isEmpty()) {
				Node s2Node = s2.pop();
				output.append(s2Node.data + " ");
				if (s2Node.left != null)
					s1.push(s2Node.left);
				if (s2Node.right != null)
					s1.push(s2Node.right);
			}
		}
		System.out.print(output);
	}
}