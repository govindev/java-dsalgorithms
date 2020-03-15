package com.challenges.gfg.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

/**
 * https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1
 * 
 * Serialization is to store a tree in an array so that it can be later restored
 * and Deserialization is reading tree back from the array. Now your task is to
 * complete the function serialize which stores the tree into an array A[ ] and
 * deSerialize which deserializes the array to tree and returns it. Note: The
 * structure of tree must be maintained.
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
 * Output Format: The output in the expected output will be the inorder
 * traversal of the returned tree.
 * 
 * Your Task: The task is to complete two methods serialize() and deSerialize().
 * 
 * Constraints: 1 <=T<= 100 1 <= Number of nodes<= 1000 1 <= Data of a node<=
 * 1000
 * 
 * Example(To be used only for expected output): Input 2 1 2 3 10 20 30 40 60
 * Output 2 1 3 40 20 60 10 30
 * 
 * @author Govind
 *
 */
class GNode {
	int data;
	GNode left;
	GNode right;

	GNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class SerializeAndDeserializeABinaryTree3 {

	static GNode buildTree3(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the Tree3
		GNode root = new GNode(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<GNode> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			GNode currGNode = queue.peek();
			queue.remove();

			// Get the current GNode's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current GNode
				currGNode.left = new GNode(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currGNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current GNode
				currGNode.right = new GNode(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currGNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(GNode root) {
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
			GNode root = buildTree3(s);

			Tree3 tr = new Tree3();
			ArrayList<Integer> A = new ArrayList<Integer>();
			tr.serialize(root, A);

			GNode getRoot = tr.deSerialize(A);
			printInorder(getRoot);
			System.out.println();
		}
	}
}// } Driver Code Ends
/*
 * Complete the given function GNode is as follows: class Tree3{ int data; Tree3
 * left,right; Tree3(int d){ data=d; left=right=null; } }
 */
//This Code is developed by: Suman Rana

class Tree3 {
	public void serialize(GNode root, ArrayList<Integer> A) {
		ArrayList<GNode> GNodes = new ArrayList<GNode>();
		if (root != null) {
			GNodes.add(root);
			A.add(root.data);
			addLeafs(A, GNodes, 0, 0);
		}
	}

	static void addLeafs(ArrayList<Integer> A, ArrayList<GNode> GNodes, int start, int end) {
		int prevLength = A.size();
		for (int i = start; i <= end; i++) {
			GNode current = GNodes.get(i);
			if (current != null) {
				if (current.left == null)
					A.add(null);
				else
					A.add(current.left.data);
				if (current.right == null)
					A.add(null);
				else
					A.add(current.right.data);
				GNodes.add(current.left);
				GNodes.add(current.right);
			}

		}
		if (prevLength != A.size())
			addLeafs(A, GNodes, end + 1, A.size() - 1);
	}

	public GNode deSerialize(ArrayList<Integer> A) {

		// Create the root of the Tree3
		GNode root = new GNode(A.get(0));
		// Push the root to the queue

		Queue<GNode> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < A.size()) {

			// Get and remove the front of the queue
			GNode currGNode = queue.peek();
			queue.remove();

			// Get the current GNode's value from the string
			Integer currVal = A.get(i);

			// If the left child is not null
			if (currVal != null) {

				// Create the left child for the current GNode
				currGNode.left = new GNode(currVal);
				// Push it to the queue
				queue.add(currGNode.left);
			}

			// For the right child
			i++;
			if (i >= A.size())
				break;

			currVal = A.get(i);

			// If the right child is not null
			if (currVal != null) {

				// Create the right child for the current GNode
				currGNode.right = new GNode(currVal);

				// Push it to the queue
				queue.add(currGNode.right);
			}
			i++;
		}
		return root;
	}
}