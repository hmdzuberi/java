package com.training.dao;

import java.sql.SQLException;
import java.util.List;

import com.training.entity.Contact;
import com.training.entity.ContactNumber;

public interface ContactDAO {

	public int addContact(Contact contact) throws SQLException;

	public int addToExistingContact(long contactID, ContactNumber contactNumber) throws SQLException;

	public int removeContact(long contactID) throws SQLException;

	public int modifyContact(long contactID, String propertyToEdit, String newValue) throws SQLException;

	public List<Contact> getContactsbyName(String contactName) throws SQLException;

	public List<Contact> getAllContacts() throws SQLException;

	public List<Contact> getContactsByRelation(String relation) throws SQLException;

	public void getRelationCount() throws SQLException;

}
