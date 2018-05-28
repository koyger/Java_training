package ru.stqa.java_training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }

    public void gotoNewContactPage() {
        click(By.linkText("add new"));
    }

    public void gotoSomeContactPage() {
        click(By.linkText("home"));
        click(By.xpath("//table[@id='maintable']/tbody/tr[11]/td[8]/a/img"));
    }
}
