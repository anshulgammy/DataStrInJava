package com.techbrunch.datastructure.ds.stack;

import java.util.ArrayList;
import java.util.List;

public class ListStack<T> implements Stack<T> {

	private List<T> data;
	private int stackPointer;

	public ListStack() {
		this.stackPointer = 0;
		this.data = new ArrayList<T>();
	}

	public void push(T data) {
		this.data.add(stackPointer++, data);
	}

	public T pop() {
		if (stackPointer > 0) {
			return this.data.remove(--stackPointer);
		} else {
			throw new IllegalArgumentException("No more items left in the stack...");
		}

	}

	public boolean contains(T data) {
		boolean foundStatus = false;
		for (int i = 0; i < stackPointer; i++) {
			if (this.data.get(i).equals(data)) {
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
