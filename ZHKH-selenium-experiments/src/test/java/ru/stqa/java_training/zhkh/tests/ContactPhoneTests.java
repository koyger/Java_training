package ru.stqa.java_training.zhkh.tests;
import org.testng.annotations.Test;
import ru.stqa.java_training.zhkh.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {
  @Test
  public void TestContactPhones () {
    app.goTo().homePage();
    ContactData contact = app.contact().allContacts().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

  }

  private String mergePhones(ContactData contact) {

    return Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(), contact.getWorkPhone())
        .stream().filter((s) -> ! s.equals(""))
        .map(TestBase::cleanedPhones)
        .collect(Collectors.joining("\n"));

  }

}
