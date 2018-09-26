package com.training;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyMap<K, V> {

	private int size;
	private int maxIndex;
	private static final int CAPACITY = 10;
	private MapEntry<K, V>[] mapEntries;

	public MyMap() {
		super();
		mapEntries = new MapEntry[CAPACITY];
		size = CAPACITY;
	}

	public int getSize() {
		return size;
	}

	public MapEntry<K, V>[] getMapEntries() {
		return mapEntries;
	}

	public void setMapEntries(MapEntry<K, V>[] mapEntries) {
		this.mapEntries = mapEntries;
		size = mapEntries.length;
		maxIndex = mapEntries.length - 1;
	}

	public V put(K key, V value) {

		V oldValue = null;

		if (key != null) {
			int i = 0;

			while (oldValue == null && i < maxIndex && mapEntries[i] != null) {

				if (mapEntries[i].getKey() == key) {
					oldValue = mapEntries[i].getValue();
					mapEntries[i].setKey(key);
					mapEntries[i].setValue(value);
				}

				i++;
			}

			if (oldValue == null) {

				mapEntries[maxIndex] = new MapEntry<>();
				mapEntries[maxIndex].setKey(key);
				mapEntries[maxIndex++].setValue(value);
			}
		}

		return oldValue;
	}

	public V get(K key) {

		V value = null;

		if (key != null) {
			int i = 0;

			while (value == null && i < size) {
				if (mapEntries[i].getKey() == key) {
					value = mapEntries[i].getValue();
				}

				i++;
			}
		}

		return value;
	}

	public Set<MapEntry<K, V>> convertToSet() {

		HashSet<MapEntry<K, V>> mapEntrySet = new HashSet<>();

		for (int i = 0; i < size; i++) {
			mapEntrySet.add(mapEntries[i]);
		}

		return mapEntrySet;
	}

	@Override
	public String toString() {
		return "MyMap [size=" + size + ", mapEntries=" + Arrays.toString(mapEntries) + "]";
	}

}
