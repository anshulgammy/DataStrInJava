package com.techbrunch.main;

import com.techbrunch.dyanamicarray.DynamicArray;
import com.techbrunch.dyanamicarray.impl.DynamicArrayImpl;

public class DyanmicArrayApplication {
	
	public static void main(String args[]) {
		final DynamicArray dynamicArray = new DynamicArrayImpl();
		final int[] numbers = {0,1,2,3,4,5,6,7,8,9,10,11,12,13};
		doAdd(numbers, dynamicArray);
		dynamicArray.insertAt(12, 55);
		dynamicArray.search(55);
	}
	
	public static void doAdd(int[] numbers, DynamicArray dynamicArray) {
		for(int i = 0; i<numbers.length; i++) {
			dynamicArray.add(numbers[i]);
		}
	}

}
