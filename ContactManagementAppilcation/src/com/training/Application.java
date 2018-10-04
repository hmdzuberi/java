package com.training;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.training.dao.ContactDAO;
import com.training.dao.impl.ContactDAOImpl;
import com.training.entity.Contact;
import com.training.entity.ContactNumber;
import com.training.utils.DbConnection;

public class Application {

	public static void main(String[] args) {

		System.out.println(DbConnection.getOracleConnection());

		long phoneNumber = Long.parseLong("9876553422");

		ContactNumber contactNumber1 = new ContactNumber("Office", phoneNumber);
		List<ContactNumber> contactNumbers = Arrays.asList(contactNumber1);

		Contact contact1 = new Contact(10003, "Hamaad", "hamaad@gmail.com", "Family", contactNumbers);

		ContactDAO contactDAO = new ContactDAOImpl();

		try {

			// contactDAO.addContact(contact1);
			// contactDAO.removeContact(10001);

			// contactDAO.modifyContact(10001, "contactName", "Hamaad Zuberi");

			// contactDAO.addToExistingContact(10003, contactNumber1);

			// System.out.println(contactDAO.getContactsbyName("Hamaad"));
			// System.out.println(contactDAO.getContactsByRelation("Family"));

			// System.out.println(contactDAO.addToExistingContact(10003,
			// contactNumber1));
			System.out.println(contactDAO.getAllContacts());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
