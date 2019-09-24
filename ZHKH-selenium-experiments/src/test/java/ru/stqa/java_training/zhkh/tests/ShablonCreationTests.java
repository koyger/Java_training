package ru.stqa.java_training.zhkh.tests;
import org.testng.annotations.Test;
import static ru.stqa.java_training.zhkh.appmanager.ApplicationManager.waitQuant;
public class ShablonCreationTests extends TestBase {

    @Test
    public void ShablonCreationTests() throws InterruptedException {

        //Contacts before = app.contact().allContacts(); т.е. запомнить, какие Шаблоны есть
        app.goTo().shablonsPage();
        app.shablon().openNew();
        app.shablon().fillSimpleShablon();
        app.shablon().saveEdits();
        Thread.sleep(1000);
    }

}

