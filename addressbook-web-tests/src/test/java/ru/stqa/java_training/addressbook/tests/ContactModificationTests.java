package ru.stqa.java_training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test(enabled = false)
    public void testContactModification(){

        app.goTo().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Petr", "Petrovich", "PetroFF",
                "petrishchev", "Mr.", "Petrosoft", "Теперь двухзвенные классы",
                "+1 999 999 99 99", "petr@gmail.com", "petr@petrosoft.com",
                "petrov.petrosoft.com", "Notes For Petrov", "TestGroup1"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().editContact(before.size() - 1);
        ContactData contactModifiedFields = new ContactData(before.get(before.size()-1).getId(),"Petr MoDiFiEd", "Petrovich MoDiFiEd",
                "PetroFF MoDiFiEd", "petrishchev", "Mr.", "Petrosoft", "Теперь двухзвенные классы",
                "+1 999 999 99 99", "petr@gmail.com", "petr@petrosoft.com", "petrov.petrosoft.com",
                "Notes For Petrov", null);
        app.getContactHelper().fillContactForm(contactModifiedFields, false);
        app.getContactHelper().updateContactForm();
        app.getContactHelper().returnToContactsPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
        before.remove(before.size() - 1);
        before.add(contactModifiedFields);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);


    }

}
