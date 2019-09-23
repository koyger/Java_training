package ru.stqa.java_training.zhkh.tests;

import org.testng.annotations.Test;
import ru.stqa.java_training.zhkh.model.ContactData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {
  @Test
  public void TestContactAddress() {
    app.goTo().homePage();
    ContactData contact = app.contact().allContacts().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));

  }

}