package ru.stqa.java_training.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){

        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Petr", "Petrovich", "PetroFF",
                "petrishchev", "Mr.", "Petrosoft", "Теперь двухзвенные классы",
                "+1 999 999 99 99", "petr@gmail.com", "petr@petrosoft.com",
                "petrov.petrosoft.com", "Notes For Petrov", "TestGroup1"));
        }
        app.getContactHelper().editFirstContact();
        app.getContactHelper().fillContactForm(new ContactData("Petr MoDiFiEd", "Petrovich MoDiFiEd",
            "PetroFF MoDiFiEd", "petrishchev", "Mr.", "Petrosoft", "Теперь двухзвенные классы",
            "+1 999 999 99 99", "petr@gmail.com", "petr@petrosoft.com", "petrov.petrosoft.com",
            "Notes For Petrov", null), false);
        app.getContactHelper().updateContactForm();
        app.getContactHelper().returnToContactsPage();




    }

}
