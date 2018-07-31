package ru.stqa.java_training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

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

        List<ContactData> before = app.contact().list();
        int index = before.size()-1;
      ContactData contactModifiedFields = new ContactData().withFirstName("Petr MoDiFiEd").withSecondName("Petrovich MoDiFiEd")
              .withLastName("PetroFF MoDiFiEd").withNickName("petrishchev MOD").withTitle("Mr.")
              .withCompany("Petrosoft").withAddress("Теперь двухзвенные классы")
              .withPhone("+1 999 999 99 99").withFirstEmail("petr@gmail.com").withSecondEmail("petr@petrosoft.com")
              .withHomePage("petrov.petrosoft.com").withNotes("Notes For Petrov").withGroup(null);
        app.contact().modify(index, contactModifiedFields);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());
        System.out.println("Before 11 = "+ before);
        System.out.println("After 11 = "+ after);
        before.remove(index);
      System.out.println("Before 22 = "+ before);
      System.out.println("After 22 = "+ after);
        before.add(contactModifiedFields);
      System.out.println("Before 33 = "+ before);
      System.out.println("After 33 = "+ after);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);


    }



}
