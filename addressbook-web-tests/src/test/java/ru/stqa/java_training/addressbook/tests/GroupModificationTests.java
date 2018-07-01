package ru.stqa.java_training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("TestGroup1", "test2", "test3"));

    }

    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("TestGroup1", "Header10", "Footer10"));
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().gotoGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);


  }
}