package ru.stqa.java_training.addressbook.tests;
import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.GroupData;
import ru.stqa.java_training.addressbook.model.Groups;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().count() == 0) {
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
    assertEquals(app.group().count(), before.size());
    Groups after = app.group().allGroups();
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(groupNewData)));


  }


}