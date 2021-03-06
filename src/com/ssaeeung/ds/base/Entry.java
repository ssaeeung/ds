package com.ssaeeung.ds.base;

public class Entry<K, V> {
	public final K key;
	public V value;
	public Entry<K, V> next;
	
	public Entry(K key, V value, Entry<K,V> next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}
	
	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Entry<K, V> getNext() {
		return next;
	}

	public void setNext(Entry<K, V> next) {
		this.next = next;
	}

	public K getKey() {
		return key;
	}

	@Override
	public String toString() {
		return "[" + this.key + ", " + this.value + "]";
	}
}
