package com.challenges.gfg.tree;

import java.util.Scanner;
import java.lang.Integer;
import java.util.HashMap;

/**
 * https://practice.geeksforgeeks.org/problems/check-for-bst/1
 * 
 * Given a binary tree, return true if it is BST, else false. For example, the
 * following tree is not BST, because 11 is in left subtree of 10. The task is
 * to complete the function isBST() which takes one argument, root of Binary
 * Tree.
 * 
 * 10 / \ 7 39 \ 11
 * 
 * Input: The input contains T, denoting number of testcases. For each testcase
 * there will be two lines. The first line contains number of edges. The second
 * line contains two nodes and a character separated by space. The first node
 * denotes data value, second node denotes where it will be assigned to the
 * previous node which will depend on character 'L' or 'R' i.e. the 2nd node
 * will be assigned as left child to the 1st node if character is 'L' and so on.
 * The first node of second line is root node. The struct or class Node has a
 * data part which stores the data, pointer to left child and pointer to right
 * child. There are multiple test cases. For each test case, the function will
 * be called individually.
 * 
 * Output: The function should return 1 if BST else return 0.
 * 
 * User Task: Since this is a functional problem you don't have to worry about
 * input, you just have to complete the function isBST().
 * 
 * Constraints: 1 <= T <= 100 0 <= Number of edges <= 100 1 <= Data of a node <=
 * 1000
 * 
 * Example: Input: 2 2 1 2 R 1 3 L 4 10 20 L 10 30 R 20 40 L 20 60 R
 * 
 * Output: 0 0
 * 
 * Explanation: Testcases 1: The given binary tree is not BST, hence the answer
 * is 0.
 * 
 * @author Govind
 *
 */
class CheckForBST {
	// driver function to test the above functions
	public static void main(String args[]) {
		// Input the number of test cases you want to run
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		CheckForBST ob = new CheckForBST();
		while (t > 0) {
			HashMap<Integer, Node> m = new HashMap<Integer, Node>();
			int n = sc.nextInt();

			Node root = null;

			while (n > 0) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);

				// cout << n1 << " " << n2 << " " << (char)lr << endl;
				Node parent = m.get(n1);
				if (parent == null) {
					parent = new Node(n1);
					m.put(n1, parent);
					if (root == null)
						root = parent;
				}

				Node child = new Node(n2);
				if (lr == 'L')
					parent.left = child;
				else
					parent.right = child;
				m.put(n2, child);
				n--;
			}

			GfG g = new GfG();
			System.out.println(g.isBST(root));
			// ob.printInorder(root);
			t--;

		}
	}
}

/*
 * A Binary Search Tree node class Node { int data; Node left, right;
 * 
 * Node(int item) { data = item; left = right = null; } }
 */
class GfG {
	int isBST(Node root) {
		// Your code here
		if (root != null) {
			return isBST(root, null, null, null, null);
		}
		return 1;
	}

	int isBST(Node current, Node parent, Node parentsParent, Boolean isCurrentLeftChildOfParent,
			Boolean isParentLeftChildOfParentsParent) {
		if (current != null) {
			Node left = current.left;
			Node right = current.right;
			if (left != null && current.data < left.data) {
				return 0;
			}
			if (right != null && current.data > right.data) {
				return 0;
			}
			if (parentsParent != null) {
				if (isParentLeftChildOfParentsParent) {
					// All the elements of the current should be less than the parent
					if (current.data > parentsParent.data) {
						return 0;
					}
				} else if (current.data < parentsParent.data) {
					// All the elements of the current should be greater than the parent
					return 0;
				}
			}
			parentsParent = parent;
			isParentLeftChildOfParentsParent = isCurrentLeftChildOfParent;
			if (isBST(left, current, parentsParent, true, isParentLeftChildOfParentsParent) == 0) {
				return 0;
			}
			if (isBST(right, current, parentsParent, false, isParentLeftChildOfParentsParent) == 0) {
				return 0;
			}
		}
		return 1;
	}
}
