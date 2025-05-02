package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {

//    @Test
//    public void canCreateContactWithEmptyFields() {
//        app.contacts().createContact(new ContactData());
//}
//
//    @Test
//    public void canCreateContact() {
//        int contactCount = app.contacts().getCount();
//        app.contacts().createContact(new ContactData().withNames("firstname", "middlename", "lastname"));
//        int newContactCount = app.contacts().getCount();
//        Assertions.assertEquals(contactCount + 1, newContactCount);
//
//    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContact(ContactData contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);

    }

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        result.add(new ContactData("firstname", "middlename", "lastname", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        result.add(new ContactData("", "middlename", "lastname", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        result.add(new ContactData("firstname", "", "lastname", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        result.add(new ContactData("firstname", "middlename", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        result.add(new ContactData("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData(randomString(i*10), randomString(i*10), randomString(i*10), randomString(i*10), "",randomString(i*10),randomString(i*10),randomString(i*10),"", "", "", "",randomString(i*10),randomString(i*10),randomString(i*10),randomString(i*10),"", "", "", "", "", "", ""));
        }
        return result;
    }

}
