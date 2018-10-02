package ru.stqa.java_training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.ContactData;
import ru.stqa.java_training.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        Contacts before = app.contact().allContacts();
        app.goTo().newContactPage();
        File photo = new File("src/test/resources/Max Plank.jpg");
        ContactData contactNew = new ContactData().withFirstName("Petr").withSecondName("Petrovich")
                .withLastName("PetroFF with Photo").withNickName("petrishchev").withTitle("Mr.")
                .withCompany("Petrosoft").withAddress("35 South Main Street, San Jose, CA")
                .withHomePhone("+1 999 999 99 99").withFirstEmail("petr@gmail.com").withSecondEmail("petr@petrosoft.com")
                .withHomePage("petrov.petrosoft.com").withNotes("Notes For Petrov").withGroup("TestGroup1").
                withPhoto(photo);
        app.contact().create(contactNew);
        Contacts after = app.contact().allContacts();
        Assert.assertEquals(after.size(), before.size() + 1);
        assertThat(after, equalTo(
                before.withAdded(contactNew.withId(after.stream().mapToInt( (g)  ->  g.getId()).max().getAsInt()))));

    }

}
