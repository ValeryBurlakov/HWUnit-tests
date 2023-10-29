package fifth_homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class ContactManager {
    private static final List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }
    public void removeAllContacts(List<Contact> clients) {
        contacts.removeAll(clients);
    }

    public void editContact(int index, Contact newContact) {
        if (index >= 0 && index < contacts.size()) {
            contacts.set(index, newContact);
        }
    }

    public void deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
        }
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public List<Contact> searchContactsByName(String clientName) {
        List<Contact> matchingContacts = contacts.stream()
                .filter(contact -> contact.getName().equalsIgnoreCase(clientName))
                .collect(Collectors.toList());

        if (matchingContacts.isEmpty()) {
            System.out.println(clientName + " is not in the book");
        } else {
            for (Contact contact : matchingContacts) {
                System.out.println("Name: " + contact.getName() + ", Email: " + contact.getEmail());
            }
        }

        return matchingContacts;
    }

    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Options:");
            System.out.println("1 - Add Contact");
            System.out.println("2 - Edit Contact");
            System.out.println("3 - Delete Contact");
            System.out.println("4 - List Contacts");
            System.out.println("5 - Search Contacts");
            System.out.println("0 - Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    contactManager.addContact(new Contact(name, email));
                    break;
                case 2:
                    System.out.print("Enter index of the contact to edit: ");
                    int editIndex = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    contactManager.editContact(editIndex, new Contact(newName, newEmail));
                    break;
                case 3:
                    System.out.print("Enter index of the contact to delete: ");
                    int deleteIndex = scanner.nextInt();
                    contactManager.deleteContact(deleteIndex);
                    break;
                case 4:
                    List<Contact> contactList = contactManager.getContacts();
                    for (int i = 0; i < contactList.size(); i++) {
                        Contact contact = contactList.get(i);
                        System.out.println("Contact " + i + ": Name - " + contact.getName() + ", Email - " + contact.getEmail());
                    }
                    if (contactList.isEmpty()) {System.out.println("Book is empty");}
                    break;
                case 5:
                    String clientName = scanner.next();
                    contactManager.searchContactsByName(clientName);
                    break;
                case 0:
                    System.out.println("Exiting Contact Manager.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }
}
