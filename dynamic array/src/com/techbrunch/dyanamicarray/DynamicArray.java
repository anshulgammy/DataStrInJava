package com.techbrunch.dyanamicarray;

public interface DynamicArray {

	public void add(int value);

	public void insertAt(int position, int value);

	public int search(int value);

	public void remove(int value);

	public void removeAt(int position);
}
