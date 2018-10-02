package com.training.dao;

import java.sql.SQLException;
import java.util.List;

import com.training.entity.Contact;

public interface ContactDAO {

	public int addContact(Contact contact) throws SQLException;

	public int removeContact(long contactID) throws SQLException;

	public int modifyContact(String contactName) throws SQLException;

	public Contact getContact() throws SQLException;

	public List<Contact> getAllContacts() throws SQLException;

	public List<Contact> getByRelation() throws SQLException;

}
