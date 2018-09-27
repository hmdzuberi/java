package com.training;

public class MapEntry<K, V> {

	private K key;
	private V value;

	public MapEntry() {
		super();
		key = null;
		value = null;
	}

	public MapEntry(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {

		return key;
	}

	public V getValue() {

		return value;
	}

	public void setKey(K key) {

		this.key = key;
	}

	public void setValue(V value) {

		this.value = value;
	}

	@Override
	public String toString() {

		return "MapEntry [key=" + key + ", value=" + value + "]";
	}

}
