package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContactWithEmptyFields() {
        app.contacts().createContact(new ContactData());
}

    @Test
    public void canCreateContact() {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(new ContactData().withNames("firstname", "middlename", "lastname"));
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);

    }

}
