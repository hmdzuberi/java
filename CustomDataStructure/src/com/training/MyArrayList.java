package com.training;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E> {

	private int size;
	private int maxIndex;
	private static final int CAPACITY = 10;
	private Object[] elements;

	public MyArrayList() {
		super();
		this.size = CAPACITY;
		this.elements = new Object[CAPACITY];
		this.maxIndex = 0;
	}

	public MyArrayList(Object[] elements) {
		this();
		this.size = elements.length;
		this.maxIndex = elements.length - 1;
		this.elements = elements;
	}

	public int add(Object newElement) {

		int result = 0;

		if (this.maxIndex == this.size - 1) {
			ensureCapacity();
		}

		this.elements[this.maxIndex++] = newElement;
		result = 1;

		return result;
	}

	private void ensureCapacity() {

		int newCapacity = this.size * 2;
		this.elements = Arrays.copyOf(this.elements, newCapacity);
	}

	public Object get(int index) throws ArrayIndexOutOfBoundsException {

		if (index > this.maxIndex)
			throw new ArrayIndexOutOfBoundsException();

		return this.elements[index];
	}

	public int remove(int index) throws ArrayIndexOutOfBoundsException {

		int result = 0;

		if (index > this.maxIndex)
			throw new ArrayIndexOutOfBoundsException();

		for (int i = 0; i < this.maxIndex; i++) {
			if (i >= index)
				this.elements[i] = this.elements[i + 1];
		}

		this.maxIndex--;
		result = 1;

		return result;
	}

	@Override
	public Iterator<E> iterator() {

		return new Iterator<E>() {

			private int index = 0;

			@Override
			public boolean hasNext() {
				return (index < maxIndex && elements[index] != null);
			}

			@Override
			public E next() {
				return (E) elements[index++];
			}
		};
	}

	@Override
	public String toString() {
		return "MyArrayList [size=" + size + ", elements=" + Arrays.toString(elements) + ", maxIndex=" + maxIndex + "]";
	}

}
