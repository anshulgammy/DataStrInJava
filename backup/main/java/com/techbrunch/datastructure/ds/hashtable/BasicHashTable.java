package com.techbrunch.datastructure.ds.hashtable;

public class BasicHashTable<K, V> {
	
	private class HashEntry<K, V> {
		private K key;
		private V value;
		public HashEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

}
