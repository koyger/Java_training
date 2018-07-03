package ru.stqa.java_training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.java_training.addressbook.model.ContactData;
import ru.stqa.java_training.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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

    public void editContact(int index) {
        wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr/td[8]/a/img")).get(index).click();
    }

  public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
  }

    public void createContact(ContactData contact) {
        wd.get("http://localhost/addressbook/edit.php");
        fillContactForm(contact, true);
        submitContactForm();
        returnToContactsPage();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contactList = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("selected[]"));
        int currentTr = 2; // Нужные нам строки начинаются с tr[2]

        for (WebElement element : elements) {
            String lastName = element.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr["+currentTr+"]/td[2]")).getText();
            String firstName = element.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr["+currentTr+"]/td[3]")).getText();
            int id = Integer.parseInt(element.getAttribute("value"));
            ContactData contact = new ContactData(id, firstName, null, lastName,
                    null, null, null,
                    null, null, null,
                    null, null, null, null);
            contactList.add(contact);
            currentTr++;
        }
        return contactList;
    }
}
