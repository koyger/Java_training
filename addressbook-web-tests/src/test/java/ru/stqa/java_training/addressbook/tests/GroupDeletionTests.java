package ru.stqa.java_training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("TestGroup1").withHeader("test2").withFooter("test3"));    }
    }

    @Test
    public void testGroupDeletion() {
        List<GroupData> before = app.group().list();
        int indexToDelete = 0;
        app.group().delete(indexToDelete);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size()  - 1);
        before.remove(indexToDelete);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);


    }




}
