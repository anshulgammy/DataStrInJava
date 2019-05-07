package com.techbrunch.datastructure.ds.linkedlist;

public class BasicLinkedList<T> implements List<T> {

	private Node firstNode;
	private Node lastNode;
	private int nodeCount = 0;

	public BasicLinkedList() {
		this.firstNode = null;
		this.lastNode = null;
		this.nodeCount = 0;
	}

	private class Node {
		private Node nextNode;
		private T nodeItem;

		public Node(T item) {
			this.nextNode = null;
			this.nodeItem = item;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public T getNodeItem() {
			return nodeItem;
		}

	}

	public int size() {
		return nodeCount;
	}

	public void add(T item) {
		Node insertedNode = null;
		// Node List is empty
		if (this.firstNode == null) {
			firstNode = new Node(item);
			lastNode = firstNode;
			insertedNode = firstNode;
		} else if (this.lastNode != null) {
			Node newLastNode = new Node(item);
			this.lastNode.setNextNode(newLastNode);
			this.lastNode = newLastNode;
			insertedNode = newLastNode;
		}
		this.nodeCount++;
	}

	public void insert(T item, int position) {
		if (size() < position) {
			throw new IllegalStateException("Invalid position provided");
		}
		Node currentNode = this.firstNode;
		for (int i = 1; i < position && currentNode != null; i++) {
			currentNode = currentNode.getNextNode();
		}
		Node newNode = new Node(item);
		Node nextNode = currentNode.getNextNode();
		currentNode.setNextNode(newNode);
		newNode.setNextNode(nextNode);
		nodeCount++;
	}

	public T remove() {
		T itemToRemove = null;
		if (this.firstNode == null) {
			throw new IllegalStateException("List is empty");
		} else {
			itemToRemove = this.firstNode.getNodeItem();
			this.firstNode = this.firstNode.getNextNode();
			nodeCount--;
		}
		return itemToRemove;
	}

	public T removeAt(int position) {
		if (size() < position) {
			throw new IllegalStateException("Invalid position provided");
		}
		T itemToRemove = null;
		Node currentNode = this.firstNode;
		Node previousNode = this.firstNode;
		for (int i = 1; i < position && currentNode != null; i++) {
			previousNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		Node nodeToBeRemoved = currentNode;
		itemToRemove = nodeToBeRemoved.getNodeItem();
		previousNode.setNextNode(nodeToBeRemoved.getNextNode());
		nodeCount--;
		return itemToRemove;
	}

	public T get(int position) {
		if (size() < position) {
			throw new IllegalStateException("Invalid position provided");
		}
		Node currentNode = this.firstNode;
		for (int i = 1; i < position && currentNode != null; i++) {
			currentNode = currentNode.getNextNode();
		}
		return currentNode.getNodeItem();
	}

	public int find(T item) {
		Node currentNode = this.firstNode;
		for (int i = 1; i <= size() && currentNode != null; i++) {
			if (currentNode.getNodeItem().equals(item)) {
				return i;
			}
			currentNode = currentNode.getNextNode();
		}
		return -1;
	}

	// for pretty printing
	public String toString() {
		StringBuffer strBuffer = new StringBuffer();
		Node currentNode = this.firstNode;
		for (int i = 1; i <= size() && currentNode != null; i++) {
			strBuffer.append(currentNode.getNodeItem());
			currentNode = currentNode.getNextNode();
			if (currentNode != null) {
				strBuffer.append(", ");
			}
		}
		return strBuffer.toString();
	}

}
