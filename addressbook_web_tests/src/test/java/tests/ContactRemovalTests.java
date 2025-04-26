package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData().withNames("firstname", "middlename", "lastname"));
        }
        int contactsCount = app.contacts().getCount();
        app.contacts().removeContact();
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactsCount - 1, newContactCount);

    }

    @Test
    void canRemoveAllContactsAtOnce() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData().withNames("firstname", "middlename", "lastname"));
        }
        app.contacts().removeAllContacts();
        Assertions.assertEquals(0, app.contacts().getCount());
    }
}
