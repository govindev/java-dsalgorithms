package com.challenges.gfg.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.io.*;

/**
 * You are given a binary tree for which you have to print its vertical order
 * traversal. your task is to complete the function verticalOrder which takes
 * one argument the root of the binary tree and prints the node of the binary
 * tree in vertical order as shown below. If there are multiple nodes passing
 * through a vertical line, then they should be printed as they appear in level
 * order traversal.
 * 
 * Note: This question is tagged as BST because to solve the questions
 * efficiently, we need to use an ordered map (map in C++ and TreeMap in Java).
 * The ordered maps are mainly implemented using self-balancing-BST.
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
 * Output Format: For each testcase, the vertical order traversal of the tree is
 * to be printed. The nodes' data are to be separated by spaces.
 * 
 * Your Task: This is a function problem. Your task is to just complete the
 * verticalOrder() function and you don't have to take any input or output. The
 * newline is automatically appended by the driver code.
 * 
 * Constraints: 1 <= T <= 100 1 <= Number of nodes <= 5000
 * 
 * Example: Input: 3 2 N 3 4 N 1 2 3 4 5 N 6 3 1 5 N 2 4 7 N N N N 6 Output: 2 4
 * 3 4 2 1 5 3 6 1 3 2 4 5 6 7 Explanation: Testcase1: 2 \ 3 / 4 As it is
 * evident from the above diagram that during vertical traversal 2, 4 will come
 * first, then 3. So output is 2 1 5 3 Testcase2: 1 / \ 2 3 / \ \ 4 5 6 As it is
 * evident from the above diagram that during vertical traversal 4 will come
 * first, then 2, then 1,5, then 3 and then 6. So the output is 4 2 1 5 3 6.
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

class VerticalTraversalOfBinaryTree {

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

		while (t-- > 0) {
			String s = br.readLine();
			Node root = buildTree(s);
			BinaryTree obj = new BinaryTree();
			obj.verticalOrder(root);
			System.out.println();

		}
	}
}
/*
 * class Node { int data; Node left, right;
 * 
 * Node(int key) { data = key; left = right = null; } }
 */

class BinaryTree {
//	static Node rootNode;
//
//	static void verticalOrder(Node root) {
//		// add your code here
//		// I should print in the order of left, current, parent(Only if current is left
//		// child of parent), right and continue
//		output = new StringBuilder();
//		rootNode = root;
//		print(root, null, null);
//		System.out.println(output);
//	}

//	static void print(Node current, Node parent, Boolean isCurrentLeftChildOfParent) {
//		if (current != null) {
//			Node left = current.left;
//			Node right = current.right;
//			if (left != null)
//				print(left, current, true);
//			// We have to figure out if this node was already printed. If so, don't print
//			// again
//			output.append(current.data + " ");
//			if (left != null && parent != null && isCurrentLeftChildOfParent) {
//				output.append(parent.data + " ");
//			}
//			if (right != null)
//				print(right, current, false);
//		}
//		return;
//	}

	static void verticalOrder(Node root) {
		StringBuilder output = new StringBuilder();
		// Using technique of Queue and TreeMap
		// 1. Create the Queue
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(root, 0));

		// 2. Create a tree map to consolidate all the horizontal distances of the nodes
		Map<Integer, ArrayList<Integer>> distances = new TreeMap<Integer, ArrayList<Integer>>();
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			Node node = pair.node;
			int hd = pair.horizontalDistance;
			if (distances.containsKey(hd)) {
				distances.get(hd).add(node.data);
			} else {
				ArrayList<Integer> nodes = new ArrayList<Integer>();
				nodes.add(node.data);
				distances.put(hd, nodes);
			}
			if (node.left != null) {
				queue.add(new Pair(node.left, hd - 1));
			}
			if (node.right != null) {
				queue.add(new Pair(node.right, hd + 1));
			}
		}

		for (Integer key : distances.keySet()) {
			for (Integer node : distances.get(key)) {
				output.append(node + " ");
			}
		}
		System.out.println(output);
	}
}

class Pair {
	Node node;
	int horizontalDistance;

	public Pair(Node node, int horizontalDistance) {
		this.node = node;
		this.horizontalDistance = horizontalDistance;
	}
}