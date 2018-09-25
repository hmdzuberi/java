package com.training;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class QuickStartTest {

	QuickStart obj;

	@Before
	public void init() {

		obj = new QuickStart();
	}

	@Test
	public void testGetMessage() {

		String expected = "HELLO";
		String actual = obj.getMessage();

		assertEquals("Testing return type of GetMessage()", expected, actual);
	}

	@Test
	public void testCalculateDiscount1() {

		double expected = 0.10;
		double actual = obj.calculateDiscount(4500);

		assertEquals("Testing CalculateDiscout 1 - argument < 5000", expected, actual, 0);

	}

	@Test
	public void testCalculateDiscount2() {

		double expected = 0.15;
		double actual = obj.calculateDiscount(5000);

		assertEquals("Testing CalculateDiscout 2 - argument = 5000", expected, actual, 0);
	}

	@Test
	public void testCalculateDiscount3() {

		double expected = 0.15;
		double actual = obj.calculateDiscount(5500);

		assertEquals("Testing CalculateDiscout 3 - argument > 5000", expected, actual, 0);
	}

	@Test(expected = RuntimeException.class)
	public void testCalculateDiscount4() {

		obj.calculateDiscount(-1);
	}

}
