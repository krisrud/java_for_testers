package manager;

import model.ContactData;
import org.openqa.selenium.By;

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

    public void removeContact() {
        returnToHomePage();
        selectContact();
        removeSelectedContact();
        returnToHomePage();
    }

    private void selectContact() {
        click(By.name("selected[]"));
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





}
