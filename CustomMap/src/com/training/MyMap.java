package com.training;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyMap<K, V> {

	private static final int CAPACITY = 10;
	private int size;
	private int maxIndex;
	private MapEntry<K, V>[] mapEntries;

	public MyMap() {
		super();
		mapEntries = new MapEntry[CAPACITY];
		size = CAPACITY;
	}

	public Set<MapEntry<K, V>> convertToSet() {

		HashSet<MapEntry<K, V>> mapEntrySet = new HashSet<>();
		for (int i = 0; i < size; i++) {
			mapEntrySet.add(mapEntries[i]);
		}
		return mapEntrySet;
	}

	public V get(K key) {

		V value = null;
		if (key != null) {
			for (int i = 0; value == null && i < size; i++) {
				if (mapEntries[i].getKey() == key) {
					value = mapEntries[i].getValue();
				}
			}
		}
		return value;
	}

	public MapEntry<K, V>[] getMapEntries() {

		return mapEntries;
	}

	public int getSize() {

		return size;
	}

	public V put(K key, V value) {

		V oldValue = null;
		if (key != null) {
			for (int i = 0; i < maxIndex && oldValue == null && mapEntries[i] == null; i++) {
				if (mapEntries[i].getKey() == key) {
					oldValue = mapEntries[i].getValue();
					mapEntries[i].setKey(key);
					mapEntries[i].setValue(value);
				}
			}
			if (oldValue == null) {
				mapEntries[maxIndex] = new MapEntry<>();
				mapEntries[maxIndex].setKey(key);
				mapEntries[maxIndex++].setValue(value);
			}
		}
		return oldValue;
	}

	public void setMapEntries(MapEntry<K, V>[] mapEntries) {

		this.mapEntries = mapEntries;
		size = mapEntries.length;
		maxIndex = mapEntries.length - 1;
	}

	@Override
	public String toString() {

		return "MyMap [size=" + size + ", mapEntries=" + Arrays.toString(mapEntries) + "]";
	}
}
