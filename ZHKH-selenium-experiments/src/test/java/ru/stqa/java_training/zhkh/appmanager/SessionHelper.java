package ru.stqa.java_training.zhkh.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {


    public SessionHelper(WebDriver wd) {

        super(wd);
    }

    public void login(String username, String password) {
        type(By.xpath("//input[@type='email']"),username);
        type(By.xpath("//input[@type='password']"),password);
        click(By.xpath("//button[@type='button']"));
    }

}
