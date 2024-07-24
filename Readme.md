# Contact Manager

The Contact Manager is a Java-based application that allows users to store, manage, and manipulate contact information. It provides functionalities to add, view, edit, and delete contacts, with the contact data being persisted using serialization to a file.

## Features

- **Add Contact:** Add a new contact with a name, phone number, and email address.
- **View Contacts:** View a list of all contacts.
- **Edit Contact:** Edit the details of an existing contact.
- **Delete Contact:** Delete a contact from the list.
- **Persistent Storage:** Contacts are saved to a file (`contacts.dat`) and loaded on application start.

## Installation

1. **Clone the repository:**
``` bash
   git clone https://github.com/yourusername/contact-manager.git
   cd contact-manager
```
2. Compile the Java files:
```bash
 javac ContactManager.java
```

3. Run the application:
``` bash
java ContactManager
    
```

## Usage

Upon running the application, the user is presented with a menu that allows them to select an action:

- **Add Contact:** Prompts for name, phone number, and email address, then saves the new contact.
- **View Contacts:** Displays all contacts with their respective details.
- **Edit Contact:** Prompts for the contact number to edit, then allows the user to update the contact's information.
- **Delete Contact:** Prompts for the contact number to delete, then removes the contact.
- **Exit:** Exits the application.

## Class Structure

- **Contact:** Represents a contact with `name`, `phoneNumber`, and `email` fields. Implements `Serializable` to allow object serialization.
- **ContactManager:** Manages a list of `Contact` objects, handles file operations to load and save contacts, and provides a menu-driven interface for user interactions.

## Use Cases

- **Personal Contact Management:** Store and manage personal contacts, update details when necessary, and keep track of important contacts.
- **Business Contact Management:** Maintain a list of business contacts, update contact information for clients or colleagues, and ensure that contact details are always up-to-date.
- **Event Planning:** Organize contact information for event participants, update and manage participant details, and ensure seamless communication.

## Contributing

Contributions are welcome! If you'd like to contribute, please fork the repository and submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any questions or inquiries, please contact [varshneyanurag691@gmail.com](mailto:varshneyanurag691@gmail.com).

