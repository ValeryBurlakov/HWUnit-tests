package fifth_homework.tests;

import fifth_homework.Contact;
import fifth_homework.ContactManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BookTest {
    private ContactManager contactManager;

    @BeforeEach
    public void setUp() {
        contactManager = new ContactManager();
    }

    @Test
    public void testAddContact() {
        contactManager.removeAllContacts(contactManager.getContacts());

        Contact contact = new Contact("Tim", "Tim@example.com");
        contactManager.addContact(contact);
        assertEquals(1, contactManager.getContacts().size());
    }

    @Test
    public void testEditContact() {
        contactManager.removeAllContacts(contactManager.getContacts());

        Contact contact1 = new Contact("John", "john@mail.com");
        Contact contact2 = new Contact("Tom", "tom@mail.com");
        contactManager.addContact(contact1);
        contactManager.addContact(contact2);

        Contact newContact = new Contact("Pitt", "Pitt@mail.com");
        contactManager.editContact(1, newContact);

        assertEquals("Pitt", contactManager.getContacts().get(1).getName());
    }

    @Test
    public void testDeleteContact() {
        contactManager.removeAllContacts(contactManager.getContacts());

        Contact contact1 = new Contact("John", "john@mail.com");
        Contact contact2 = new Contact("Tom", "tom@mail.com");
        contactManager.addContact(contact1);
        contactManager.addContact(contact2);

        contactManager.deleteContact(0);
        assertEquals(1, contactManager.getContacts().size());
        assertEquals("Tom", contactManager.getContacts().get(0).getName());
    }

    @Test
    public void testSearchContact() {
        contactManager.removeAllContacts(contactManager.getContacts());
        Contact contact1 = new Contact("John", "john@mail.com");
        Contact contact3 = new Contact("John", "jo3hn@mail.com");
        Contact contact2 = new Contact("Tom", "tom@mail.com");

        contactManager.addContact(contact1);
        contactManager.addContact(contact2);
        contactManager.addContact(contact3);

        List<Contact> matchingContacts = contactManager.searchContactsByName("John");

        assertEquals(2, matchingContacts.size());
        assertEquals("john@mail.com", matchingContacts.get(0).getEmail());
        assertEquals("jo3hn@mail.com", matchingContacts.get(1).getEmail());



    }

    @Test
    public void testContactManagerEndToEnd() {
        contactManager.removeAllContacts(contactManager.getContacts());

        // Add contacts
        contactManager.addContact(new Contact("John", "john@example.com"));
        contactManager.addContact(new Contact("Jane", "jane@example.com"));
        contactManager.addContact(new Contact("Sarah", "sarah@example.com"));
        assertEquals(3, contactManager.getContacts().size());

        // Edit contact
        contactManager.editContact(1, new Contact("Jane Doe", "jane.doe@example.com"));
        List<Contact> contacts = contactManager.getContacts();
        assertEquals("Jane Doe", contacts.get(1).getName());
        assertEquals("jane.doe@example.com", contacts.get(1).getEmail());

        // Search contacts by name
        List<Contact> searchedContacts = contactManager.searchContactsByName("jane Doe");
        assertEquals(1, searchedContacts.size());
        assertEquals("Jane Doe", searchedContacts.get(0).getName());
        assertEquals("jane.doe@example.com", searchedContacts.get(0).getEmail());

        // Delete contact
        contactManager.deleteContact(0);
        assertEquals(2, contactManager.getContacts().size());

        // remove all contacts
        contactManager.removeAllContacts(contactManager.getContacts());
        assertTrue(contactManager.getContacts().isEmpty());
    }
}