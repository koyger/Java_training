package ru.stqa.java_training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.java_training.addressbook.model.ContactData;
import ru.stqa.java_training.addressbook.model.GroupData;

public class ContactHelper extends HelperBase {

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }
    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getSecondName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("nickname"), contactData.getNickName());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getPhone());
        type(By.name("email"), contactData.getFirstEmail());
        type(By.name("email2"), contactData.getSecondEmail());
        type(By.name("homepage"), contactData.getHomePage());
        type(By.name("notes"), contactData.getNotes());

    }
    public void submitContactForm() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }
    public void returnToContactsPage(){
        click(By.linkText("home"));
    }

}
