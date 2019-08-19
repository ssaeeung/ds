package com.ssaeeung.ds.Impl;

import java.util.Arrays;

import com.ssaeeung.ds.base.Entry;

public class HashMap<K, V> {
	private Entry<K, V>[] buckets;
	private static final int INITIAL_CAPACITY = 1 << 3; // 8
	private int size = 0;
	
	public HashMap() {
		this(INITIAL_CAPACITY);
	}
	
	public HashMap(int capacity) {
		this.buckets = new Entry[capacity];
	}
	
	public V get(K key) {
	    Entry<K, V> bucket = buckets[getHash(key) % getBucketSize()];

	    while (bucket != null) {
	        if (key == bucket.key) {
	            return bucket.value;
	        }
	        bucket = bucket.next;
	    }
	    return null;
	}
	
	public void put(K key, V value) {
		Entry<K, V> entry = new Entry<>(key, value, null);
		int bucket = getHash(key) % getBucketSize();
		System.out.println("Bucket index=" + bucket + ", Bucket=" + Arrays.toString(buckets));
		
		Entry<K, V> existing = buckets[bucket];
		if (existing == null) {
			buckets[bucket] = entry;
			size++;
		} else {
			// Traverse on the linkedList and check key for intermediate nodes
			while (existing.next != null) {
				System.out.println("Key=" + existing.key + ", Value=" + existing.value);
				// Same key, re-write the value then exit
				if (existing.key.equals(key)) {
					existing.value = value;
					return;
				}
				// move to next node on the list of this bucket.
				existing = existing.next;
			}
			
			// Last Node, same key => replace val, diff key => add new node.
			if (existing.key.equals(key)) {
				System.out.println("Existing key, overwrite w/ new value");
				// Same key, re-write the value.
				existing.value = value;
			} else {
				System.out.println("Diff key");
				// diff key, add a new entry as a next node in the linkedList.
				existing.next = entry;
				size++;
			}
		}
	}

	private int getBucketSize() {
		return buckets.length;
	}

	public int getHash(K key) {
		String varString = "a" + "b" + "c" + key;
		return Math.abs(varString.hashCode());
	} 

	public static void main(String ...strings) {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("aa", "00");
		hm.put("aa", "99");
		hm.put("bb", "11");
		hm.put("cc", "22");

		System.out.println("Value=" + hm.get("aa"));
		System.out.println("Value=" + hm.get("bb"));
		System.out.println("Value=" + hm.get("cc"));
	}
}

