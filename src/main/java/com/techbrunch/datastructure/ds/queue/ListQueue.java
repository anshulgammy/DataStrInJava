package com.techbrunch.datastructure.ds.queue;

import java.util.ArrayList;
import java.util.List;

public class ListQueue<T> implements Queue<T> {
	private List<T> data;
	int front;
	int end;

	public ListQueue() {
		this.data = new ArrayList<T>(100);
		this.front = -1; // Queue is empty
		this.end = -1; // Queue is empty
	}

	public int size() {
		if (front == -1 && end == -1) {
			return 0;
		} else {
			return end - front + 1;
		}
	}

	public void enQueue(T data) {
		// check to see if the queue is empty
		if (size() == 0) {
			front++;
			end++;
			this.data.add(end, data);
		} else if ((end + 1) % (100) == front) {
			// check if the queue is full or not.
			throw new IllegalArgumentException("Queue is full");
		} else {
			// the queue is neither empty nor the queue is full.
			end++;
			this.data.add(end, data);
		}
	}

	public T deQueue() {
		// check if the queue is empty or not.
		if (size() == 0) {
			throw new IllegalArgumentException("Queue is empty");
		} else if (front == 0 && end == 0) {
			// checking if there is only one element left in the queue
			final T itemToBeDequeued = this.data.get(front);
			// this.data[front] = null;
			front = -1;
			end = -1;
			return itemToBeDequeued;

		} else {
			final T itemToBeDequeued = this.data.get(front);
			// this.data[front] = null;
			front++;
			return itemToBeDequeued;
		}
	}

	public boolean contains(T data) {
		boolean found = false;
		// check if the queue is empty or not.
		if (size() == 0) {
			throw new IllegalArgumentException("Queue is empty");
		} else {
			for (front = 0; front < size(); front++) {
				if (this.data.get(front).equals(data)) {
					found = true;
					break;
				}
			}
			front = 0;
		}
		return found;
	}

	public T access(int position) {
		T itemToAccess = null;
		int pinPoint = 0;
		if (position > size()) {
			throw new IllegalArgumentException("Position provided is not proper");
		}
		while (pinPoint <= position) {
			if (pinPoint == position) {
				itemToAccess = this.data.get(pinPoint);
				break;
			}
			pinPoint++;
		}
		return itemToAccess;
	}
}
