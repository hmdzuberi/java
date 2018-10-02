package com.training;

import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyParser extends DefaultHandler {

	private List<Employee> employeeList;
	private Employee employee;

	private boolean bAge;
	private boolean bName;
	private boolean bGender;
	private boolean bRole;

	// https://www.journaldev.com/1198/java-sax-parser-example
	@Override
	public void startDocument() throws SAXException {

		System.out.println("Start Document");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		super.characters(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		super.endElement(uri, localName, qName);
	}

	@Override
	public void endDocument() throws SAXException {

		System.out.println("End Document");
	}
}
