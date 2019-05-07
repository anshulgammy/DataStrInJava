package com.techbrunch.datastructure.ds.stack;

public interface Stack<T> {
	public void push(T data);

	public T pop();

	public boolean contains(T data);

	public T access(T data);
	
	public int size();
}
