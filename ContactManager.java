import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Contact implements Serializable {
    String name;
    String phoneNumber;
    String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}

public class ContactManager {
    private static final String FILE_NAME = "contacts.dat";
    private ArrayList<Contact> contacts;
    private Scanner scanner;

    public ContactManager() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
        loadContacts();
    }

    private void loadContacts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            contacts = (ArrayList<Contact>) ois.readObject();
        } catch (FileNotFoundException e) {
            // File not found, start with an empty list
            contacts = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveContacts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(contacts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();
        contacts.add(new Contact(name, phoneNumber, email));
        saveContacts();
        System.out.println("Contact added.");
    }

    private void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    private void editContact() {
        viewContacts();
        if (!contacts.isEmpty()) {
            System.out.print("Enter the number of the contact to edit: ");
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < contacts.size()) {
                System.out.print("Enter new name: ");
                contacts.get(index).name = scanner.nextLine();
                System.out.print("Enter new phone number: ");
                contacts.get(index).phoneNumber = scanner.nextLine();
                System.out.print("Enter new email address: ");
                contacts.get(index).email = scanner.nextLine();
                saveContacts();
                System.out.println("Contact updated.");
            } else {
                System.out.println("Invalid contact number.");
            }
        }
    }

    private void deleteContact() {
        viewContacts();
        if (!contacts.isEmpty()) {
            System.out.print("Enter the number of the contact to delete: ");
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < contacts.size()) {
                contacts.remove(index);
                saveContacts();
                System.out.println("Contact deleted.");
            } else {
                System.out.println("Invalid contact number.");
            }
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\nContact Manager");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        ContactManager cm = new ContactManager();
        cm.menu();
    }
}
