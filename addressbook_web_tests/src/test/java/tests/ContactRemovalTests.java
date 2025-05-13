package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "1", "2", "3", "4", "randomFile(\"src/test/resources/images\")", "5", "6",
                    "7", "8", "9", "10", "11", "12", "13", "14", "15",
                    "16", "June", "1900", "17", "June", "2000", "", ""));
        }
//        int contactsCount = app.contacts().getCount();
//        app.contacts().removeContact();
//        int newContactCount = app.contacts().getCount();
//        Assertions.assertEquals(contactsCount - 1, newContactCount);
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);

    }

    @Test
    void canRemoveAllContactsAtOnce() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData().withNames("firstname", "lastname"));
        }
        app.contacts().removeAllContacts();
        Assertions.assertEquals(0, app.hbm().getContactCount());
    }
}
