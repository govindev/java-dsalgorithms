package com.dsalgo.trees;

public class TreeNode {
	private Integer data;
	private TreeNode leftChildNode;
	private TreeNode rightChildNode;

	public TreeNode(Integer data) {
		this.data = data;
	}

	public void insert(TreeNode newNode) {
		if (this.data < newNode.getData()) {
			if (this.getLeftChildNode() != null) {
				this.getLeftChildNode().insert(newNode);
			} else {
				this.setLeftChildNode(newNode);
			}
		} else {
			if (this.getRightChildNode() != null) {
				this.getRightChildNode().insert(newNode);
			} else {
				this.setRightChildNode(newNode);
			}
		}
	}

	public Integer search(Integer data) {
		if (this.getData() == data) {
			return data;
		} else if (data < this.getData() && this.getLeftChildNode() != null) {
			this.getLeftChildNode().search(data);
		} else if (data > this.getData() && this.getRightChildNode() != null) {
			this.getRightChildNode().search(data);
		}
		return null;
	}

	public Integer getData() {
		return data;
	}

	public TreeNode getLeftChildNode() {
		return leftChildNode;
	}

	public void setLeftChildNode(TreeNode leftChildNode) {
		this.leftChildNode = leftChildNode;
	}

	public TreeNode getRightChildNode() {
		return rightChildNode;
	}

	public void setRightChildNode(TreeNode rightChildNode) {
		this.rightChildNode = rightChildNode;
	}

}
