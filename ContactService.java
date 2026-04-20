package projectone;
import java.util.ArrayList;

public class ContactService {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact is null");
        }

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getContactId().equals(contact.getContactId())) {
                throw new IllegalArgumentException("ID already exists");
            }
        }

        contacts.add(contact);
    }

    public void deleteContact(String contactId) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getContactId().equals(contactId)) {
                contacts.remove(i);
                return;
            }
        }

        throw new IllegalArgumentException("Cannot delete contact");
    }

    public void updateFirstName(String contactId, String firstName) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getContactId().equals(contactId)) {
                contacts.get(i).setFirstName(firstName);
                return;
            }
        }

        throw new IllegalArgumentException("Cannot update first name");
    }

    public void updateLastName(String contactId, String lastName) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getContactId().equals(contactId)) {
                contacts.get(i).setLastName(lastName);
                return;
            }
        }

        throw new IllegalArgumentException("Cannot update last name");
    }

    public void updatePhone(String contactId, String phone) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getContactId().equals(contactId)) {
                contacts.get(i).setPhone(phone);
                return;
            }
        }

        throw new IllegalArgumentException("Cannot update phone number");
    }

    public void updateAddress(String contactId, String address) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getContactId().equals(contactId)) {
                contacts.get(i).setAddress(address);
                return;
            }
        }

        throw new IllegalArgumentException("Cannot update address");
    }
}
