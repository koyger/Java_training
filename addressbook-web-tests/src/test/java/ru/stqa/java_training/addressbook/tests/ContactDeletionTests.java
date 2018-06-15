package ru.stqa.java_training.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {
  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Petr", "Petrovich", "PetroFF",
          "petrishchev", "Mr.", "Petrosoft", "Теперь двухзвенные классы",
          "+1 999 999 99 99", "petr@gmail.com", "petr@petrosoft.com",
          "petrov.petrosoft.com", "Notes For Petrov", "TestGroup1"));
    }
    app.getContactHelper().editFirstContact();
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().returnToContactsPage();
  }
}
