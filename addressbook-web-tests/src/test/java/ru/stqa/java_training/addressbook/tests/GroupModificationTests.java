package ru.stqa.java_training.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.GroupData;
import java.util.*;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withName("TestGroup1").withHeader("test2").withFooter("test3"));    }
  }

  @Test
  public void testGroupModification() {
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    int indexToModify = before.size() - 1; // будем модифицировать последнюю в визуальном списке группу на веб-страничке
    int idOfModified = before.get(indexToModify).getId();
    GroupData groupNewData = new GroupData()
            .withId(idOfModified).withName("TestGroup1 MODIFIED").withHeader("Header10").withFooter("Footer10");
    app.group().modify(indexToModify, groupNewData); // Основная модификация
    app.goTo().groupPage();
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());
    before.remove(indexToModify);
    before.add(groupNewData);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }


}