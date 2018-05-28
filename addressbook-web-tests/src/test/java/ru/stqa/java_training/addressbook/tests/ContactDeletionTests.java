package ru.stqa.java_training.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion(){
        app.getNavigationHelper().gotoSomeContactPage();
        app.getContactHelper().submitContactDeletion();
        app.getContactHelper().returnToContactsPage();
    }
}
