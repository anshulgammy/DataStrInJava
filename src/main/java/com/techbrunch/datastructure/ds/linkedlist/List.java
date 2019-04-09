package com.techbrunch.datastructure.ds.linkedlist;

public interface List<T> {
	public void add(T item);

	public void insert(T item, int position);

	public T remove();

	public T removeAt(int position);

	public T get(int position);

	public int find(T item);
}
