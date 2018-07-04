package ru.stqa.java_training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void groupPage() {

        if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new")))
        { return; }
        else {  click(By.linkText("groups"));   }
    }

    public void gotoNewContactPage() {
      wd.get("http://localhost/addressbook/edit.php");
    }

    public void gotoHomePage() {
        if (isElementPresent(By.id("maintable")))
        {  return; }
            else
            {       click(By.linkText("home")); }
    }

}
