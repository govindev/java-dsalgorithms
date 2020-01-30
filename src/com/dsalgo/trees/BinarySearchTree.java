package com.dsalgo.trees;

public class BinarySearchTree {
	private TreeNode root;

	public void insert(Integer data) {
		TreeNode node = new TreeNode(data);
		node.setLeftChildNode(null);
		node.setRightChildNode(null);
		if (this.root == null) {
			this.root = node;
		} else {
			this.root.insert(node);
		}
	}

	public Integer search(Integer data) {
		if (this.root != null) {
			if (this.root.getData() == data) {
				return data;
			} else {
				this.root.search(data);
			}
		}
		return null;
	}

	public void delete(Integer data) {
		if (this.root != null) {
			TreeNode current = this.root;
			TreeNode parent = null;
			while (current != null) {
				if (current.getData() == data) {
					if (current.getLeftChildNode() == null && current.getRightChildNode() == null) {
						// 1. No child elements
						if (parent != null) {
							// If it is the leaf node
							if (data < parent.getData()) {
								parent.setLeftChildNode(null);
							} else {
								parent.setRightChildNode(null);
							}
						} else {
							// If it has only root node
							this.root = null;
						}
						break;
					} else if (current.getLeftChildNode() == null) {
						// 2. Single child element
						if (parent == null) {
							this.root = current.getRightChildNode();
						} else {
							parent.setLeftChildNode(current.getRightChildNode());
						}
					} else if (current.getRightChildNode() == null) {
						if (parent == null) {
							this.root = current.getLeftChildNode();
						} else {
							parent.setRightChildNode(current.getLeftChildNode());
						}
					} else {
						// 3. Both child elements
						// a. Find the successor (Right side Left most value)
						TreeNode successor = current.getRightChildNode();
						while (successor.getLeftChildNode() != null) {
							successor = successor.getLeftChildNode();
						}
						// b. Assign Left child of current node to left child of successor
						successor.setLeftChildNode(current.getLeftChildNode());
						// c. Assign Right child of current node to right child of successor
						// Before doing this operation we should do
						// c1. Assign (if any) right child of successor to the left child of successor's
						// parent
						if (successor.getRightChildNode() != null) {
							current.getRightChildNode().setLeftChildNode(successor.getRightChildNode());
						}
						// Continue setting right child to the successor
						successor.setRightChildNode(current.getRightChildNode());
						// d. Remove the connection between the successors parent and the successor
						current.getRightChildNode().setLeftChildNode(null);
						// e. Assign Child(Determine left/right) of current's parent to successor
						if (parent.getLeftChildNode().getData() == current.getData()) {
							parent.setLeftChildNode(successor);
						} else {
							parent.setRightChildNode(successor);
						}

					}
				} else if (data < current.getData() && current.getLeftChildNode() != null) {
					parent = current;
					current = current.getLeftChildNode();
				} else if (data > current.getData() && current.getRightChildNode() != null) {
					parent = current;
					current = current.getRightChildNode();
				}
			}
		}
	}
}
