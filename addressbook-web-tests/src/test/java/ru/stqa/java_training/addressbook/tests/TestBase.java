package ru.stqa.java_training.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.java_training.addressbook.appmanager.ApplicationManager;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

  public static String cleanedPhones(String phone) {
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }

  public static String cleanedEmails(String phone) {
    return phone.replaceAll("\\s","");
  }


  @BeforeSuite
    public void setUp() throws Exception {
        app.init();

    }

    @AfterSuite
    public void tearDown() throws Exception {
        app.stop();
    }

}
