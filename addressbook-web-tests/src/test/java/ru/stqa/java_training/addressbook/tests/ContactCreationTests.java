package ru.stqa.java_training.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        app.getNavigationHelper().gotoNewContactPage();
        app.getContactHelper().fillContactForm(new ContactData("Petr", "Petrovich", "PetroFF",
            "petrishchev", "Mr.", "Petrosoft", "Теперь двухзвенные классы",
            "+1 999 999 99 99", "petr@gmail.com", "petr@petrosoft.com",
            "petrov.petrosoft.com", "Notes For Petrov", "TestGroup1"), true);
        app.getContactHelper().submitContactForm();
        app.getContactHelper().returnToContactsPage();


    }


}
