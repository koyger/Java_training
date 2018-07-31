package ru.stqa.java_training.addressbook.tests;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.GroupData;
import ru.stqa.java_training.addressbook.model.Groups;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().allGroups().size() == 0) {
      app.group().create(new GroupData().withName("TestGroup1").withHeader("test2").withFooter("test3"));    }
  }

  @Test
  public void testGroupModification() {
    app.goTo().groupPage();
    Groups before = app.group().allGroups();
    GroupData modifiedGroup = before.iterator().next();
    GroupData groupNewData = new GroupData()
            .withId(modifiedGroup.getId()).withName("TestGroup1 MODIFIED").withHeader("Header10").withFooter("Footer10");
    app.group().modify(groupNewData); // Основная модификация
    app.goTo().groupPage();
    Groups after = app.group().allGroups();
    assertEquals(after.size(), before.size());
    assertThat(after, CoreMatchers.equalTo(before.without(modifiedGroup).withAdded(groupNewData)));


  }


}