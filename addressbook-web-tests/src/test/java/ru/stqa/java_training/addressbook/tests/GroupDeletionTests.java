package ru.stqa.java_training.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.GroupData;
import ru.stqa.java_training.addressbook.model.Groups;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().allGroups().size() == 0) {
            app.group().create(new GroupData().withName("TestGroup1").withHeader("test2").withFooter("test3"));    }
    }

    @Test
    public void testGroupDeletion() {
        Groups before = app.group().allGroups();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Groups after = app.group().allGroups();
        assertEquals(after.size(), before.size()  - 1);
        assertThat(after, CoreMatchers.equalTo(before.without(deletedGroup)));

    }

}
