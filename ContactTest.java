package projectone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {
	@Test
    public void testValidContact() {
        Contact contact = new Contact("1", "Ethan", "Wilson", "555555555", "523 West Street");
        assertEquals("1", contact.getContactId());
        assertEquals("Ethan", contact.getFirstName());
        assertEquals("Wilson", contact.getLastName());
        assertEquals("555555555", contact.getPhone());
        assertEquals("523 West Street", contact.getAddress());
    }

    @Test
    public void testBadContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Ethan", "Wilson", "555555555", "523 West Street");
        });
    }

    @Test
    public void testBadFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", null, "Wilson", "555555555", "523 West Street");
        });
    }

    @Test
    public void testBadLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Ethan", null, "555555555", "523 West Street");
        });
    }

    @Test
    public void testBadPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Ethan", "Wilson", null, "523 West Street");
        });
    }

    @Test
    public void testBadAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Ethan", "Wilson", "555555555", null);
        });
    }

    @Test
    public void testUpdateFields() {
        Contact contact = new Contact("1", "Ethan", "Wilson", "555555555", "523 West Street");
        contact.setFirstName("Mike");
        contact.setLastName("Jones");
        contact.setPhone("666666666");
        contact.setAddress("456 New Street");

        assertEquals("Mike", contact.getFirstName());
        assertEquals("Jones", contact.getLastName());
        assertEquals("666666666", contact.getPhone());
        assertEquals("456 New Street", contact.getAddress());

	}
}

