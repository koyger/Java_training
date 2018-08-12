package ru.stqa.java_training.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.ContactData;

public class ContactPhoneTests extends TestBase {
  @Test
  public void TestContactPhones () {
    app.goTo().homePage();
    ContactData contact = app.contact().allContacts().iterator().next();
    ContactData ContactInfoFromEditForm = app.contact().infoFromEditForm(contact);

  }
}
