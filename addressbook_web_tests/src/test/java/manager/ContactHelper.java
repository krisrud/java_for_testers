package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        //returnToHomePage();
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }



    private void initContactCreation() {
        click(By.linkText("add new"));
    }

    private void returnToHomePage() {
        click(By.linkText("home"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
    }

    public int getCount() {
        returnToHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeContact(ContactData contact) {
        returnToHomePage();
        selectContact(contact);
        removeSelectedContact();
        returnToHomePage();
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    private void removeSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void removeAllContacts() {
        returnToHomePage();
        selectAllContacts();
        removeSelectedContact();
    }

    private void selectAllContacts() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();

        }
    }

    public List<ContactData> getList() {
        returnToHomePage();
        var contacts = new ArrayList<ContactData>();
        var trs = manager.driver.findElements(By.cssSelector("tr[name='entry']"));
        for (var tr : trs) {
            var firstname = tr.findElement(By.cssSelector("td:nth-child(3)")).getText();
            var lastname = tr.findElement(By.cssSelector("td:nth-child(2)")).getText();
            var checkbox = tr.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withId(id).withNames(firstname, lastname));
        }
        return contacts;
    }





}
