package com.techbrunch.datastructure.ds.queue;

public interface Queue<T> {
	public int size();
	public void enQueue(T data);
	public T deQueue();
	public boolean contains(T data);
	public T access(int position);
}
