package ru.stqa.java_training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.java_training.addressbook.model.ContactData;
import ru.stqa.java_training.addressbook.model.Contacts;

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
        type(By.name("home"), contactData.getHomePhone());
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

    // УСТАРЕВШИЙ МЕТОД
    public void editContactById(ContactData contactToEdit) {
      int idToEdit = contactToEdit.getId();
      List<WebElement> elements = wd.findElements(By.name("selected[]"));
        for (WebElement element : elements) {
          if ((Integer.parseInt(element.getAttribute("value")) == idToEdit)) {
              element.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr/td[8]")).click();
              return;
            }
          }
        }


    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
  }

    public void create(ContactData contactToEDit) {
        wd.get("http://localhost/addressbook/edit.php");
        fillContactForm(contactToEDit, true);
        submitContactForm();
        returnToContactsPage();
    }

    public void modify(ContactData contactModifiedFields, ContactData contactToEdit) {
        //editContactById(contactToEdit);
      initContactModificationById(contactToEdit.getId());
        fillContactForm(contactModifiedFields, false);
        updateContactForm();
        returnToContactsPage();
    }



    public void delete(ContactData contactToEDit) {
      initContactModificationById(contactToEDit.getId());
     // editContactById(contactToEDit);
      submitContactDeletion();
      returnToContactsPage();
  }



  public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }



    public List<ContactData> list() {
        List<ContactData> contactList = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("selected[]"));
        int currentTr = 2; // Нужные нам строки начинаются с tr[2]
        for (WebElement element : elements) {
            String lastName = element.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr["+currentTr+"]/td[2]")).getText();
            String firstName = element.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr["+currentTr+"]/td[3]")).getText();
            int id = Integer.parseInt(element.getAttribute("value"));
            contactList.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
            currentTr++;
          //tr[@class='odd']/td[8]/a/img
        }
        return contactList;
    }

  public Contacts allContacts() {
    Contacts contacts = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastName = cells.get(1).getText();
      String firstName = cells.get(2).getText();
      String allPhones = cells.get(5).getText();
            contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName).
          withAllPhones(allPhones));
    }
    return contacts;
  }
  /* Отложил в стороночку работавший ранее метод
  public Contacts allContacts() {
    Contacts contacts = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("selected[]"));
    int currentTr = 2; // Нужные нам строки начинаются с tr[2]
    for (WebElement row : rows) {
      int id = Integer.parseInt(row.getAttribute("value"));
      String lastName = row.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr["+currentTr+"]/td[2]")).getText();
      String firstName = row.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr["+currentTr+"]/td[3]")).getText();

      contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
      currentTr++;
    }
    return contacts;
  }
   */


  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname).withHomePhone(home).
            withMobilePhone(mobile).withWorkPhone(work);
     
  }

  private void initContactModificationById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();

      // 1й способ найти иконку редактирования
      //WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
      //WebElement row = checkbox.findElement(By.xpath("./../.."));
      //List<WebElement> cells = row.findElements(By.tagName("td"));
      //cells.get(7).findElement(By.tagName("a")).click();

      // 2й способ найти иконку редактирования
      //wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();

    // 3й способ найти иконку редактирования
    //wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();

    // 4й способ найти иконку редактирования, самая короткая строка
    //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();


  }
}
