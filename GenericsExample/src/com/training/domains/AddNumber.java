package com.training.domains;

import java.util.ArrayList;
import java.util.List;

public class AddNumber<T, E> {

	private T digit;
	private List<E> list;

	public AddNumber() {
		super();
		list = new ArrayList<>();
	}

	public AddNumber(T digit, List<E> list) {
		super();
		this.digit = digit;
		this.list = list;
	}

	public T getDigit() {
		return digit;
	}

	public void setDigit(T digit) {
		this.digit = digit;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public void addObject(E element) {
		list.add(element);
	}
}
