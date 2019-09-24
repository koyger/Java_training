package ru.stqa.java_training.zhkh.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static ru.stqa.java_training.zhkh.appmanager.ApplicationManager.waitQuant;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void shablonsPage() throws InterruptedException { // переход на Шаблоны Соответствий из карты
        Thread.sleep(waitQuant);
        wd.findElement(By.cssSelector("button.settings-button > span.icon")).click();
        wd.findElement(By.cssSelector("span.arrow.expand")).click();
        wd.findElement(By.xpath("//div[11]/a/span/span[2]")).click();
        wd.findElement(By.xpath("//button[@type='button']"));
        Thread.sleep(waitQuant);
    }

    public void groupPage() {
        if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new")))
        { return; }
        else {  click(By.linkText("groups"));   }
    }
    public void homePage() {
        if (isElementPresent(By.id("maintable")))
        {  return; }
            else
            {       click(By.linkText("home")); }
    }

}
