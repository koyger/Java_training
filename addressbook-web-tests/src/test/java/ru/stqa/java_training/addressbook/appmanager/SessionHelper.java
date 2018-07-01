package ru.stqa.java_training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase {


    public SessionHelper(WebDriver wd) {

        super(wd);
    }

    public void login(String username, String password) {
        type(By.name("user"),username);
        type(By.name("pass"),password);
        //click(By.cssSelector("#LoginForm > input[type=submit]:nth-child(7)"));
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }

}
