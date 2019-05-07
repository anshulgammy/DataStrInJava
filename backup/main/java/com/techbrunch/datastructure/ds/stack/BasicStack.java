package com.techbrunch.datastructure.ds.stack;

public class BasicStack<T> implements Stack<T> {

	private T[] data;
	private int stackPointer;

	public BasicStack() {
		this.stackPointer = 0;
		this.data = (T[]) new Object[1000];

	}

	public void push(T data) {
		this.data[stackPointer++] = data;
	}

	public T pop() {
		if (stackPointer > 0) {
			return this.data[--stackPointer];
		} else {
			throw new IllegalArgumentException("No more items left in the stack...");
		}

	}

	public boolean contains(T data) {
		boolean foundStatus = false;
		for (int i = 0; i < stackPointer; i++) {
			if (this.data[i].equals(data)) {
				foundStatus = true;
				break;
			}
		}
		return foundStatus;
	}

	public T access(T data) {
		while (stackPointer != 0) {
			T topStackData = pop();
			if (topStackData.equals(data)) {
				return topStackData;
			}
		}
		throw new IllegalArgumentException("Item Not Found...");
	}

	public int size() {
		return stackPointer;
	}

}
