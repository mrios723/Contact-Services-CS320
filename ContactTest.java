import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void testValidContact() {

        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    void testInvalidContactId() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Smith",
                    "1234567890", "Address");
        });
    }

    @Test
    void testInvalidFirstName() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1",
                    "VeryLongFirstName",
                    "Smith",
                    "1234567890",
                    "Address");
        });
    }

    @Test
    void testInvalidPhone() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1",
                    "John",
                    "Smith",
                    "12345",
                    "Address");
        });
    }

    @Test
    void testInvalidAddress() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1",
                    "John",
                    "Smith",
                    "1234567890",
                    "This address is way too long to be accepted");
        });
    }
}
