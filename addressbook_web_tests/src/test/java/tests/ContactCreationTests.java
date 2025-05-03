package tests;

import common.CommonFunctions;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContact(ContactData contact) {
        var oldContacts = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size() - 1).id()).withoutNames("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);

    }

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        result.add(new ContactData("", "firstname", "middlename", "lastname", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        result.add(new ContactData("", "", "middlename", "lastname", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        result.add(new ContactData("", "firstname", "", "lastname", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        result.add(new ContactData("", "firstname", "middlename", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        result.add(new ContactData("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        //result.add(new ContactData().withPhoto("src/test/resources/images/avatar.png"));
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData("", CommonFunctions.randomString(i*10), CommonFunctions.randomString(i*10), CommonFunctions.randomString(i*10), CommonFunctions.randomString(i*10), "", CommonFunctions.randomString(i*10), CommonFunctions.randomString(i*10), CommonFunctions.randomString(i*10),"", "", "", "", CommonFunctions.randomString(i*10), CommonFunctions.randomString(i*10), CommonFunctions.randomString(i*10), CommonFunctions.randomString(i*10),"", "", "", "", "", "", ""));
        }
        return result;
    }

    @Test
    void canCreateContactWithPhoto() {
        app.contacts().createContact(new ContactData().withPhoto(randomFile("src/test/resources/images")));
    }

}
