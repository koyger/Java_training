package ru.stqa.java_training.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.ContactData;
import ru.stqa.java_training.addressbook.model.Contacts;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContactModificationTests extends TestBase {

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
    public void testContactModification(){

      Contacts before = app.contact().allContacts();
      ContactData modifiedContact = before.iterator().next();
      System.out.println("Modified contact = " + modifiedContact);
      ContactData newContactData = new ContactData().withId(modifiedContact.getId()).withFirstName("Petr MoDiFiEd").withSecondName("Petrovich MoDiFiEd")
              .withLastName("PetroFF MoDiFiEd").withNickName("petrishchev MOD").withTitle("Mr.")
              .withCompany("Petrosoft").withAddress("Теперь двухзвенные классы")
              .withPhone("+1 999 999 99 99").withFirstEmail("petr@gmail.com").withSecondEmail("petr@petrosoft.com")
              .withHomePage("petrov.petrosoft.com").withNotes("Notes For Petrov").withGroup(null);
      app.contact().modify(newContactData, modifiedContact);
      Contacts after = app.contact().allContacts();
      System.out.println("Before = " + before);
      System.out.println("Before Modified = " + before.without(modifiedContact).withAdded(newContactData));
      System.out.println("After = " + after);
      Assert.assertEquals(after.size(), before.size());
      assertThat(after, equalTo(before.without(modifiedContact).withAdded(newContactData)));

    }



}
