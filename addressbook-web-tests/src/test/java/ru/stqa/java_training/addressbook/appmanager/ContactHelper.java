package ru.stqa.java_training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.java_training.addressbook.model.ContactData;
import ru.stqa.java_training.addressbook.model.GroupData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }
    public void fillContactForm(ContactData contactData, boolean creation) {
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
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }



    }

    public void submitContactForm() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }
    public void updateContactForm() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }


    public void returnToContactsPage(){
        click(By.linkText("home"));
    }

    public void submitContactDeletion() {
        click(By.xpath("//div[@id='content']/form[2]/input[2]"));
    }

    public void editFirstContact() {

        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }
}
