package ru.stqa.java_training.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        Set<ContactData> before = app.contact().allContacts();
        app.goTo().newContactPage();
        ContactData contactNew = new ContactData().withFirstName("Petr").withSecondName("Petrovich")
                .withLastName("PetroFF from Jose").withNickName("petrishchev").withTitle("Mr.")
                .withCompany("Petrosoft").withAddress("35 South Main Street, San Jose, CA")
                .withPhone("+1 999 999 99 99").withFirstEmail("petr@gmail.com").withSecondEmail("petr@petrosoft.com")
                .withHomePage("petrov.petrosoft.com").withNotes("Notes For Petrov").withGroup("TestGroup1");
        app.contact().create(contactNew);
        Set<ContactData> after = app.contact().allContacts();
        Assert.assertEquals(after.size(), before.size() + 1);
        contactNew.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(contactNew);
        Assert.assertEquals(before, after);



    }




}
