package com.challenges.gfg.tree;

import java.util.*;
import java.io.*;

/**
 * Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place.
 * The left and right pointers in nodes are to be used as previous and next
 * pointers respectively in converted DLL. The order of nodes in DLL must be
 * same as Inorder of the given Binary Tree. The first node of Inorder traversal
 * (left most node in BT) must be head node of the DLL.
 * 
 * TreeToList
 * 
 * Input:
 * 
 * First line of input contains the number of test cases T. For each test case,
 * there will be only a single line of input which is a string representing the
 * tree as described below:
 * 
 * The values in the string are in the order of level order traversal of the
 * tree where, numbers denotes node values, and a character “N” denotes NULL
 * child.
 * 
 * For example:
 * 
 * For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N
 * 
 * Output: For each test case, in a new line, print front to end and back to end
 * traversals of DLL.
 * 
 * Your Task: You don't have to take input. Complete the function bToDLL() that
 * takes node and head as parameter. The driver code prints the DLL both ways.
 * 
 * Constraints: 1 <= T <= 100 1 <= Number of nodes <= 1000 1 <= Data of a node
 * <= 1000
 * 
 * Example: Input: 2 1 3 2 10 20 30 40 60 Output: 3 1 2 2 1 3 40 20 60 10 30 30
 * 10 60 20 40 Explanation: Testcase1: The tree is 1 / \ 3 2 So, DLL would be
 * 3<=>1<=>2 Testcase2: The tree is 10 / \ 20 30 / \ 40 60 So, DLL would be
 * 40<=>20<=>60<=>10<=>30.
 * 
 * @author Govind
 *
 */
class BTTDNode {
	BTTDNode left, right;
	int data;

	BTTDNode(int d) {
		data = d;
		left = right = null;
	}

}

class BinaryTreeToDLL {

	static BTTDNode buildTree(String str) throws IOException {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		BTTDNode root = new BTTDNode(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<BTTDNode> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			BTTDNode currBTTDNode = queue.peek();
			queue.remove();

			// Get the current BTTDNode's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current BTTDNode
				currBTTDNode.left = new BTTDNode(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currBTTDNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current BTTDNode
				currBTTDNode.right = new BTTDNode(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currBTTDNode.right);
			}
			i++;
		}

		return root;
	}

	void inorder(BTTDNode BTTDNode) {
		if (BTTDNode == null)
			return;
		else
			inorder(BTTDNode.left);
		System.out.print(BTTDNode.data + " ");
		inorder(BTTDNode.right);
	}

	public static void printList(BTTDNode head) {
		BTTDNode prev = head;
		while (head != null) {
			System.out.print(head.data + " ");
			prev = head;
			head = head.right;
		}

		System.out.println();
		while (prev != null) {
			System.out.print(prev.data + " ");
			prev = prev.left;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			BTTDNode root = buildTree(s);
			GfG g = new GfG();

			BTTDNode ans = g.bToDLL(root);
			printList(ans);
			t--;
			System.out.println();
		}

	}
}

class GfG {
	BTTDNode head;
	BTTDNode prev;

	BTTDNode bToDLL(BTTDNode root) {
		if (root != null) {
			if (root.left != null) {
				bToDLL(root.left);
			}
			BTTDNode temp = new BTTDNode(root.data);
			if (head == null) {
				head = root;
				prev = head;
			} else {
				prev.right = temp;
				temp.left = prev;
				prev = temp;
			}
			if (root.right != null) {
				bToDLL(root.right);
			}
		}
		return head;
	}
}