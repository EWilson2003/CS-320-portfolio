package projectone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "Ethan", "Wilson", "555555555", "523 West Street");
        service.addContact(contact);

        assertDoesNotThrow(() -> service.updateFirstName("1", "Mike"));
    }

    @Test
    public void testDuplicateContactId() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "Ethan", "Wilson", "555555555", "523 West Street");
        Contact c2 = new Contact("1", "Carly", "Jensen", "444444444", "523 Elm Street");

        service.addContact(c1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(c2);
        });
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "Ethan", "Wilson", "555555555", "523 West Street");

        service.addContact(c1);
        service.deleteContact("1");

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("1", "Mike");
        });
    }

    @Test
    public void testUpdateAllFields() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "Ethan", "Wilson", "555555555", "523 West Street");

        service.addContact(c1);
        service.updateFirstName("1", "Mike");
        service.updateLastName("1", "Jones");
        service.updatePhone("1", "666666666");
        service.updateAddress("1", "456 New Street");

        assertDoesNotThrow(() -> service.updateFirstName("1", "Ed"));
    }
}