package com.training;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {

	private int size = 0;
	private static final int CAPACITY = 10;
	private Object[] elements;

	public MyArrayList() {
		super();
		this.elements = new Object[CAPACITY];
		this.size = CAPACITY;
	}

	public MyArrayList(Object[] elements) {
		this();
		this.size = elements.length;
		this.elements = elements;
	}

	public int add(Object newElement) {

		if (this.elements.length == this.size) {
			ensureCapacity();
		}

		this.elements[size] = newElement;
		size++;

		return 1;
	}

	private void ensureCapacity() {

		int newCapacity = this.size * 2;
		this.elements = Arrays.copyOf(this.elements, newCapacity);
	}

	public Object get(int index) throws ArrayIndexOutOfBoundsException {

		if (index > this.size)
			throw new ArrayIndexOutOfBoundsException();

		return this.elements[index];
	}

	public int remove(int index) throws ArrayIndexOutOfBoundsException {

		if (index > this.size)
			throw new ArrayIndexOutOfBoundsException();

		for (int i = 0; i < this.size; i++) {
			if (i >= index)
				this.elements[i] = this.elements[i + 1];
		}

		this.size--;

		return 1;
	}

	@Override
	public Iterator<T> iterator() {

		return new Iterator<T>() {

			private int index = 0;

			@Override
			public boolean hasNext() {
				return (index < size && elements[index] != null);
			}

			@Override
			public T next() {
				T result = null;

				if (!hasNext())
					result = (T) elements[index++];

				return result;
			}
		};
	}

	@Override
	public String toString() {
		return "MyArrayList [size=" + size + ", elements=" + elements.length + "]";
	}
}
