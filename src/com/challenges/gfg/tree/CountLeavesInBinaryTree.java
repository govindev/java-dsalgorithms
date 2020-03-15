package com.challenges.gfg.tree;

//INITIAL CODE
import java.util.*;
import java.io.*;

/**
 * https://practice.geeksforgeeks.org/problems/count-leaves-in-binary-tree/1
 * 
 * Given a binary tree, count leaves in it. For example, there are two leaves in
 * below tree
 * 
 * 1 / \ 10 39 / 5
 * 
 * Input: The task is to complete the method which takes one argument, root of
 * Binary Tree. The struct Node has a data part which stores the data, pointer
 * to left child and pointer to right child. There are multiple test cases. For
 * each test case, this method will be called individually.
 * 
 * Output: The function should return count of leaves
 * 
 * Constraints: 1 <=T<= 30 1 <=Number of nodes<= 100 1 <=Data of a node<= 1000
 * 
 * Example: Input: 2 2 1 2 R 1 3 L 4 10 20 L 10 30 R 20 40 L 20 60 R
 * 
 * Output: 2 3
 * 
 * There are two test casess. First case represents a tree with 3 nodes and 2
 * edges where root is 1, left child of 1 is 3 and right child of 1 is 2. Second
 * test case represents a tree with 4 edges and 5 nodes.
 * 
 * @author Govind
 *
 */

//A Binary Tree ENode
class ENode {
	int data;
	ENode left, right;

	ENode(int item) {
		data = item;
		left = right = null;
	}
}

class CountLeavesInBinaryTree {
	void inorder(ENode ENode) {
		if (ENode == null)
			return;
		else
			inorder(ENode.left);
		System.out.print(ENode.data + " ");
		inorder(ENode.right);

	}

	// driver function to test the above functions
	public static void main(String args[]) throws IOException {
		CountLeavesInBinaryTree CLN = new CountLeavesInBinaryTree();
		// Index index_obj = new Index();
		// Input the number of test cases you want to run

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			HashMap<Integer, ENode> m = new HashMap<Integer, ENode>();

			int n = Integer.parseInt(br.readLine());

			ENode root = null;

			String nums[] = br.readLine().split(" ");

			int mm = n;
			for (int idx = 0; idx < mm; idx++) {

				int n1 = Integer.parseInt(nums[idx * 3]);
				int n2 = Integer.parseInt(nums[idx * 3 + 1]);
				String lr = nums[idx * 3 + 2];

				ENode parent = m.get(n1);
				if (parent == null) {
					parent = new ENode(n1);
					m.put(n1, parent);
					if (root == null)
						root = parent;
				}

				ENode child = new ENode(n2);
				if (lr.equals("L"))
					parent.left = child;
				else
					parent.right = child;
				m.put(n2, child);
			}

			CountLeavesInBinaryTreeHelper g = new CountLeavesInBinaryTreeHelper();
			int res = g.countLeaves(root);
			System.out.println(res);
			// CLN.inorder(root);
			t--;
			// System.out.println();
		}
		br.close();
	}
}

class CountLeavesInBinaryTreeHelper {
	int countLeaves(ENode ENode) {
		if (ENode != null) {
			if (ENode.left == null && ENode.right == null) {
				return 1;
			} else {
				return (countLeaves(ENode.left) + countLeaves(ENode.right));
			}
		}
		return 0;
	}
}
