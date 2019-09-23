package ru.stqa.java_training.zhkh.tests;
import org.testng.annotations.Test;
import ru.stqa.java_training.zhkh.model.GroupData;
import ru.stqa.java_training.zhkh.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().allGroups();
        GroupData group = new GroupData().withName("TestGroup1").withHeader("test2").withFooter("test3");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size() + 1));
        Groups after = app.group().allGroups();
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt( (g)  ->  g.getId()).max().getAsInt())) ) );

    }
    @Test
    public void testBadGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().allGroups();
        GroupData group = new GroupData().withName("TestGroup1'").withHeader("test2").withFooter("test3");
        app.group().create(group);

        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().allGroups();

        assertThat(after, equalTo(before));

    }

}
