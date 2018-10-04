package com.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.dao.ContactDAO;
import com.training.entity.Contact;
import com.training.entity.ContactNumber;
import com.training.utils.DbConnection;

public class ContactDAOImpl implements ContactDAO {

	private Connection con;

	public ContactDAOImpl() {

		con = DbConnection.getOracleConnection();
	}

	private List<Contact> convertToContactList(ResultSet rs) throws SQLException {

		boolean contactExists;
		List<Contact> contactList = new ArrayList<>();

		while (rs.next()) {

			contactExists = false;
			Contact contact = new Contact();

			contact.setContactID(rs.getLong("contactID"));
			contact.setContactName(rs.getString("contactName"));
			contact.setEmailID(rs.getString("emailID"));
			contact.setRelation(rs.getString("relation"));

			String contactType = rs.getString("contactType");
			long phoneNumber = rs.getLong("phoneNo");

			ContactNumber contactNumber = new ContactNumber(contactType, phoneNumber);

			for (Contact existingContact : contactList)
				if (contact.getContactID() == existingContact.getContactID()) {
					contactExists = true;
					existingContact.addContactNumber(contactNumber);
				}

			if (!contactExists) {
				contact.addContactNumber(contactNumber);
				contactList.add(contact);
			}
		}

		return contactList;
	}

	@Override
	public int addContact(Contact contact) throws SQLException {

		int contactAdded = 0;
		int phoneNumberAdded = 0;

		String sql1 = "insert into hz_contactdetails values (?, ?, ?, ?)";
		PreparedStatement pstmt1 = con.prepareStatement(sql1);

		pstmt1.setLong(1, contact.getContactID());
		pstmt1.setString(2, contact.getContactName());
		pstmt1.setString(3, contact.getEmailID());
		pstmt1.setString(4, contact.getRelation());

		contactAdded = pstmt1.executeUpdate();
		System.out.println(contactAdded + ": contact added");

		String sql2 = "insert into hz_phonenumbers values (?, ?, ?)";
		PreparedStatement pstmt2 = con.prepareStatement(sql2);

		pstmt2.setLong(2, contact.getContactID());

		for (ContactNumber contactNumber : contact.getContactNumbers()) {
			pstmt2.setLong(1, contactNumber.getPhoneNumber());
			pstmt2.setString(3, contactNumber.getContactType());

			phoneNumberAdded += pstmt2.executeUpdate();
		}

		System.out.println(phoneNumberAdded + ": phone numbers added");

		if (contactAdded != 0 && phoneNumberAdded != 0)
			return contactAdded;
		else
			return 0;
	}

	@Override
	public int removeContact(long contactID) throws SQLException {

		int contactRemoved = 0;
		int phoneNumberRemoved = 0;

		String sql2 = "delete from hz_phonenumbers where contactID = ?";
		PreparedStatement pstmt2 = con.prepareStatement(sql2);

		pstmt2.setLong(1, contactID);
		phoneNumberRemoved = pstmt2.executeUpdate();
		System.out.println(phoneNumberRemoved + ": phone numbers removed");

		String sql1 = "delete from hz_contactdetails where contactID = ?";
		PreparedStatement pstmt1 = con.prepareStatement(sql1);

		pstmt1.setLong(1, contactID);
		contactRemoved = pstmt1.executeUpdate();
		System.out.println(contactRemoved + ": contact removed");

		if (contactRemoved != 0 && phoneNumberRemoved != 0)
			return contactRemoved;
		else
			return 0;
	}

	@Override
	public int modifyContact(long contactID, String propertyToEdit, String newValue) throws SQLException {

		int contactModified = 0;

		String sql = "update hz_contactdetails set " + propertyToEdit + " = ? where contactID = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);

		// pstmt.setString(1, propertyToEdit);
		pstmt.setString(1, newValue);
		pstmt.setLong(2, contactID);

		contactModified = pstmt.executeUpdate();
		System.out.println(contactModified + ": contact modified");

		return contactModified;
	}

	@Override
	public List<Contact> getAllContacts() throws SQLException {

		String sql = "select * from hz_contactdetails natural join hz_phonenumbers order by contactName";
		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		return convertToContactList(rs);
	}

	@Override
	public List<Contact> getContactsbyName(String contactName) throws SQLException {

		String sql = "select * from hz_contactdetails natural join hz_phonenumbers where contactName = ? order by contactName";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, contactName);

		ResultSet rs = pstmt.executeQuery();

		return convertToContactList(rs);
	}

	@Override
	public List<Contact> getContactsByRelation(String relation) throws SQLException {

		String sql = "select * from hz_contactdetails natural join hz_phonenumbers where relation = ? order by relation, contactName";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, relation);

		ResultSet rs = pstmt.executeQuery();

		return convertToContactList(rs);
	}

	@Override
	public int addToExistingContact(long contactID, ContactNumber contactNumber) throws SQLException {

		int phoneNumberAdded = 0;

		String sql = "insert into hz_phonenumbers values (?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setLong(2, contactID);
		pstmt.setLong(1, contactNumber.getPhoneNumber());
		pstmt.setString(3, contactNumber.getContactType());

		phoneNumberAdded = pstmt.executeUpdate();

		System.out.println(phoneNumberAdded + ": phone numbers added");

		return phoneNumberAdded;
	}

	@Override
	public void getRelationCount() throws SQLException {

		String sql = "SELECT relation, COUNT(*) FROM HZ_CONTACTDETAILS GROUP BY relation";
		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString(1) + ": " + rs.getInt(2));
		}

	}

}
