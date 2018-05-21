package ru.stqa.java_training.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {



    @Test
    public void testGroupDeletion() {
        gotoGroupPage();
        selectGroup();
        deleteSelectedGroups();
        returnToGroupPage();
    }


}
