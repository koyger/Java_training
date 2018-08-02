package ru.stqa.java_training.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.ContactData;
import ru.stqa.java_training.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;

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

    Contacts before = app.contact().allContacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().allContacts();
    System.out.println("Before = " + before);
    System.out.println("After = " + after);
    Assert.assertEquals(after.size(), before.size() -1);
    Assert.assertEquals(before, after);
    assertThat(after, CoreMatchers.equalTo(before.without(deletedContact)));
    
  }


}
