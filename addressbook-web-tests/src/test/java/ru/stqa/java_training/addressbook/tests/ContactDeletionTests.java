package ru.stqa.java_training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Petr").withSecondName("Petrovich")
              .withLastName("PetroFF from Jose").withNickName("petrishchev").withTitle("Mr.")
              .withCompany("Petrosoft").withAddress("35 South Main Street, San Jose, CA")
              .withPhone("+1 999 999 99 99").withFirstEmail("petr@gmail.com").withSecondEmail("petr@petrosoft.com")
              .withHomePage("petrov.petrosoft.com").withNotes("Notes For Petrov").withGroup("TestGroup1"));
    }
  }
  @Test
  public void testContactDeletion() {

    Set<ContactData> before = app.contact().allContacts();
    ContactData deletedContact = before.iterator().next();
    int index = before.size() -1;
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().allContacts();
    Assert.assertEquals(after.size(), before.size() -1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);


  }


}
