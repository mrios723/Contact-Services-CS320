package service;

import java.util.Objects;

public class Contact {
    private final String contactId;     // not updatable
    private String firstName;           // updatable
    private String lastName;            // updatable
    private String phone;               // updatable
    private String address;             // updatable

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        this.contactId = validateId(contactId, "contactId");
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    private static String validateId(String id, String fieldName) {
        if (id == null) throw new IllegalArgumentException(fieldName + " must not be null");
        if (id.length() > 10) throw new IllegalArgumentException(fieldName + " must be <= 10 characters");
        return id;
    }

    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("firstName must not be null");
        if (firstName.length() > 10) throw new IllegalArgumentException("firstName must be <= 10 characters");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) throw new IllegalArgumentException("lastName must not be null");
        if (lastName.length() > 10) throw new IllegalArgumentException("lastName must be <= 10 characters");
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null) throw new IllegalArgumentException("phone must not be null");
        if (!phone.matches("\\d{10}")) throw new IllegalArgumentException("phone must be exactly 10 digits");
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null) throw new IllegalArgumentException("address must not be null");
        if (address.length() > 30) throw new IllegalArgumentException("address must be <= 30 characters");
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(contactId, contact.contactId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId);
    }
}
