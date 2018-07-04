package ru.stqa.java_training.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test(enabled = false)
    public void testContactCreation() {

        List<ContactData> before = app.getContactHelper().getContactList();
        app.goTo().gotoNewContactPage();
        ContactData contactNew = new ContactData("Petr", "Petrovich", "PetroFF from Jose",
                "petrishchev", "Mr.", "Petrosoft", "35 South Main Street, San Jose, CA",
                "+1 999 999 99 99", "petr@gmail.com", "petr@petrosoft.com",
                "petrov.petrosoft.com", "Notes For Petrov", "TestGroup1");
        app.getContactHelper().fillContactForm(contactNew, true);
        app.getContactHelper().submitContactForm();
        app.getContactHelper().returnToContactsPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
        before.add(contactNew);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);



    }


}
