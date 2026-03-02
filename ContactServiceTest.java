import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    void testAddContact() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "1",
                "John",
                "Doe",
                "1234567890",
                "Address");

        service.addContact(contact);

        assertNotNull(service.getContact("1"));
    }

    @Test
    void testAddDuplicateContact() {

        ContactService service = new ContactService();

        Contact contact1 = new Contact(
                "1",
                "John",
                "Doe",
                "1234567890",
                "Address");

        Contact contact2 = new Contact(
                "1",
                "Jane",
                "Smith",
                "0987654321",
                "Address2");

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    void testDeleteContact() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "1",
                "John",
                "Doe",
                "1234567890",
                "Address");

        service.addContact(contact);
        service.deleteContact("1");

        assertNull(service.getContact("1"));
    }

    @Test
    void testUpdateContact() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "1",
                "John",
                "Doe",
                "1234567890",
                "Address");

        service.addContact(contact);

        service.updateContact(
                "1",
                "Jane",
                "Smith",
                "0987654321",
                "New Address");

        Contact updated = service.getContact("1");

        assertEquals("Jane", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("0987654321", updated.getPhone());
        assertEquals("New Address", updated.getAddress());
    }

    @Test
    void testUpdateInvalidContact() {

        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact(
                    "99",
                    "John",
                    "Doe",
                    "1234567890",
                    "Address");
        });
    }
}
