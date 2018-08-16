package ru.stqa.java_training.addressbook.tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.GroupData;
import ru.stqa.java_training.addressbook.model.Groups;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().count() == 0) {
            app.group().create(new GroupData().withName("TestGroup1").withHeader("test2").withFooter("test3"));    }
    }

    @Test
    public void testGroupDeletion() {
        Groups before = app.group().allGroups();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        assertEquals(app.group().count(), before.size()  - 1);
        Groups after = app.group().allGroups();
        assertThat(after, equalTo(before.without(deletedGroup)));

    }

}
