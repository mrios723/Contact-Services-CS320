import java.util.ArrayList;
import java.util.List;

public class ContactService {

    private List<Contact> contacts = new ArrayList<>();

    // Add contact
    public void addContact(Contact contact) {

        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        // Check for duplicate ID
        for (Contact c : contacts) {
            if (c.getContactId().equals(contact.getContactId())) {
                throw new IllegalArgumentException("Duplicate contact ID");
            }
        }

        contacts.add(contact);
    }

    // Delete contact by ID
    public void deleteContact(String contactId) {

        contacts.removeIf(contact ->
                contact.getContactId().equals(contactId));
    }

    // Update contact fields
    public void updateContact(String contactId,
                              String firstName,
                              String lastName,
                              String phone,
                              String address) {

        for (Contact contact : contacts) {

            if (contact.getContactId().equals(contactId)) {

                if (firstName != null) {
                    contact.setFirstName(firstName);
                }

                if (lastName != null) {
                    contact.setLastName(lastName);
                }

                if (phone != null) {
                    contact.setPhone(phone);
                }

                if (address != null) {
                    contact.setAddress(address);
                }

                return;
            }
        }

        throw new IllegalArgumentException("Contact not found");
    }

    // Helper for testing
    public Contact getContact(String contactId) {

        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }

        return null;
    }
}
