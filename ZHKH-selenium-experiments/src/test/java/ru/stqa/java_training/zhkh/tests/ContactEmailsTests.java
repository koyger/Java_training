package ru.stqa.java_training.zhkh.tests;

import org.testng.annotations.Test;
import ru.stqa.java_training.zhkh.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailsTests extends TestBase {
  @Test
  public void TestContactEmails () {
    app.goTo().homePage();
    ContactData contact = app.contact().allContacts().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));

  }

  private String mergeEmails(ContactData contact) {

    return Arrays.asList(contact.getFirstEmail(),contact.getSecondEmail(), contact.getThirdEmail())
        .stream().filter((s) -> ! s.equals(""))
        .map(TestBase:: cleanedEmails)
        .collect(Collectors.joining("\n"));

  }

}
