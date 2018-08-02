package ru.stqa.java_training.addressbook.tests;
import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.ContactData;
import ru.stqa.java_training.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        Contacts before = app.contact().allContacts();
        app.goTo().newContactPage();
        ContactData contactNew = new ContactData().withFirstName("Petr").withSecondName("Petrovich")
                .withLastName("PetroFF from Jose").withNickName("petrishchev").withTitle("Mr.")
                .withCompany("Petrosoft").withAddress("35 South Main Street, San Jose, CA")
                .withPhone("+1 999 999 99 99").withFirstEmail("petr@gmail.com").withSecondEmail("petr@petrosoft.com")
                .withHomePage("petrov.petrosoft.com").withNotes("Notes For Petrov").withGroup("TestGroup1");
        app.contact().create(contactNew);
        Contacts after = app.contact().allContacts();
        Assert.assertEquals(after.size(), before.size() + 1);
        assertThat(after, CoreMatchers.equalTo(before.withAdded(contactNew)));

    }




}
