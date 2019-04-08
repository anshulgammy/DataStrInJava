package com.techbrunch.datastructure.ds.queue;

public class BasicQueue<T> {
	private T[] data;
	int front;
	int end;

	public BasicQueue() {
		this.data = (T[]) new Object[100];
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
			this.data[end] = data;
		} else if ((end + 1) % (this.data.length) == front) {
			// check if the queue is full or not.
			throw new IllegalArgumentException("Queue is full");
		} else {
			// the queue is not empty and the queue is not full.
			end++;
			this.data[end] = data;
		}
	}

	public T deQueue() {
		// check if the queue is empty or not.
		if (size() == 0) {
			throw new IllegalArgumentException("Queue is empty");
		} else if (front == end) {
			// checking if there is only one element left in the queue
			final T itemToBeDequeued = this.data[front];
			this.data[front] = null;
			front = -1;
			end = -1;
			return itemToBeDequeued;

		} else {
			final T itemToBeDequeued = this.data[front];
			this.data[front] = null;
			front++;
			return itemToBeDequeued;
		}
	}

	public boolean contains(T data) {
		boolean found = false;
		// check if the queue is empty or not.
		if (size() == 0) {
			throw new IllegalArgumentException("Queue is empty");
		} else if (front == end) {
			// if there is only one data in the queue.
			if (this.data[front].equals(data)) {
				found = true;
			}
		} else {
			while (front <= end) {
				if (this.data[front].equals(data)) {
					found = true;
					break;
				} else {
					if (front < end) {
						front++;
					}
				}
			}
		}
		return found;
	}

	public T access(int position) {
		T itemToAccess = null;
		int pinPoint = 0;
		if (position > this.data.length) {
			throw new IllegalArgumentException("Position provided is not proper");
		}
		while (pinPoint <= position) {
			if (pinPoint == position) {
				itemToAccess = this.data[pinPoint];
				break;
			}
			pinPoint++;
		}
		return itemToAccess;
	}
}
