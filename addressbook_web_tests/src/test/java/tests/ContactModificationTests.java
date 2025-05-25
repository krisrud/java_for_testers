package tests;

import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase {
    /*
    @Test
    void canModifyContact(){
        if (app.hbm().getContactCount() == 0)  {
            app.hbm().createContact(new ContactData("", "1", "2", "3", "4", "randomFile(\"src/test/resources/images\")", "5", "6",
                    "7", "8", "9", "10", "11", "12", "13", "14", "15",
                    "16", "June", "1900", "17", "June", "2000", ""));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = new ContactData().withNames("modified firstname", "modified lastname");
        app.contacts().modifyContact(oldContacts.get(index), testData);
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withId(oldContacts.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    void canAddContactToGroup() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "name", "name header", "name footer"));
        }
        if (app.hbm().getContactCount() == 0 || app.jdbc().getContactsWithoutGroup().size() == 0)  {
            app.hbm().createContact(new ContactData("", "1", "2", "3", "4", "randomFile(\"src/test/resources/images\")", "5", "6",
                    "7", "8", "9", "10", "11", "12", "13", "14", "15",
                    "16", "June", "1900", "17", "June", "2000", ""));
        }
        var grouplist = app.hbm().getGroupList();
        var rnd = new Random();
        var index = rnd.nextInt(grouplist.size());
        var group = grouplist.get(index);

        var contactlist = app.jdbc().getContactsWithoutGroup();
        var rnd2 = new Random();
        var index2 = rnd2.nextInt(contactlist.size());
        var contact = contactlist.get(index2);

        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contacts().addContactInGroup(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());

    }

    @Test
    void canDeleteContactFromGroup() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "name", "name header", "name footer"));
        }
        if (app.hbm().getContactCount() == 0 || app.jdbc().getContactsWithoutGroup().size() == 0)  {
            app.contacts().createContact(new ContactData()
                    .withNames(CommonFunctions.randomString(10), CommonFunctions.randomString(10)), app.hbm().getGroupList().get(0));
        }
        var grouplist = app.jdbc().getGroupsWithContacts();
        var rnd = new Random();
        var index = rnd.nextInt(grouplist.size());
        var group = grouplist.get(index);

        var contactlist = app.hbm().getContactsInGroup(group);
        var rnd2 = new Random();
        var index2 = rnd2.nextInt(contactlist.size());
        var contact = contactlist.get(index2);

        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contacts().deleteContactFromGroup(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size() - 1, newRelated.size());
    }*/


}
