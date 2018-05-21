package ru.stqa.java_training.addressbook;
import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("TestGroup1", "test2", "test3"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
