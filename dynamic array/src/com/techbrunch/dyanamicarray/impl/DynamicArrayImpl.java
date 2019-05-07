package com.techbrunch.dyanamicarray.impl;

import java.util.Arrays;

import com.techbrunch.dyanamicarray.DynamicArray;

public class DynamicArrayImpl implements DynamicArray {
	final int initialCapacity = 10;
	int[] baseArray = new int[initialCapacity];
	int currentPosition = 0;

	@Override
	public void add(int value) {
		if (currentPosition < baseArray.length) {
			baseArray[currentPosition] = value;
			currentPosition++;
		} else {
			System.out.println("Array is full...");
			System.out.println("Re-initializating the array with twice the initial capacity");
			int[] tempArray = new int[2 * initialCapacity];
			for (int i = 0; i < baseArray.length; i++) {
				tempArray[i] = baseArray[i];
			}
			baseArray = tempArray;
			baseArray[currentPosition] = value;
			currentPosition++;
		}
		System.out.println("Array Status:: " + Arrays.toString(baseArray));
	}

	@Override
	public void insertAt(int position, int value) {
		if (position > baseArray.length) {
			// index out of bounds
			throw new IndexOutOfBoundsException("position provided is out the capacity of the array");
		}
		if (position < currentPosition) {
			int[] midItems = new int[currentPosition - position];
			for (int i = position - 1; i < currentPosition; i++) {
				midItems[i] = baseArray[i];
			}

		} else {
			currentPosition = position;
			baseArray[currentPosition] = value;
			currentPosition++;
		}
	}

	@Override
	public int search(int value) {
		for (int i = 0; i < baseArray.length; i++) {
			if (baseArray[i] == value) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void remove(int value) {

	}

	@Override
	public void removeAt(int position) {

	}

}
