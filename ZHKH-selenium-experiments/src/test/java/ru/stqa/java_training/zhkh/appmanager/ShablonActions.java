package ru.stqa.java_training.zhkh.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static ru.stqa.java_training.zhkh.appmanager.ApplicationManager.waitQuant;

public class ShablonActions extends HelperBase {

    public ShablonActions(WebDriver wd) {
        super(wd);
    }

    public void openNew() throws InterruptedException {
        click(By.xpath("//button[@type='button']"));
        Thread.sleep(waitQuant);  //После нажатия кнопки "Создать" нужно время для отрисовки
    }

    public void fillSimpleShablon() throws InterruptedException {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        type(By.xpath("//span[2]/input"), "Шаблон " + timeStamp); //время добавляем для уникальности имени шаблона
        type(By.xpath("//app-form-input[2]/label/span[2]/input"), "1100592"); //взял один из существующих приборов
        Thread.sleep(waitQuant);
        fillShablonLine("P1", "47913: Текущее давление в канале 1");
        fillShablonLine("P2", "47916: Текущее давление в канале 2");
        fillShablonLine("P3", "47919: Текущее давление в канале 3");
        fillShablonLine("P4", "47922: Текущее давление в канале 4");
    }

    public void fillShablonLine(String lineName, String vzletParameterCode) {
        //заполнение строки шаблона соответствия
        String pipeDirection = "Под.";
        String instantOrCumulative = "Мгн.";
        String unitOfMeasurement = "кгс/см2";
        String formulaB = "*10.197";
        String normaType = "Zulu";
        String zuluId = "11491";
        String nameInZulu = "Pout_pod";
        String formulaZ = "/10";
        String marginalDeviation = "10";

        new Select(wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='" + lineName + "'])[1]/following::select[1]"))).
                selectByVisibleText(vzletParameterCode);
        new Select(wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='" + lineName + "'])[1]/following::select[2]"))).
                selectByVisibleText(pipeDirection);
        new Select(wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='" + lineName + "'])[1]/following::select[4]"))).
                selectByVisibleText(instantOrCumulative);
        new Select(wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='" + lineName + "'])[1]/following::select[6]"))).
                selectByVisibleText(unitOfMeasurement);
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='" + lineName + "'])[1]/following::input[1]")).
                sendKeys(formulaB);
        new Select(wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='" + lineName + "'])[1]/following::select[7]"))).
                selectByVisibleText(normaType);
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='" + lineName + "'])[1]/following::input[2]")).
                sendKeys(zuluId);
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='" + lineName + "'])[1]/following::input[3]")).
                sendKeys(nameInZulu);
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='" + lineName + "'])[1]/following::input[7]")).
                sendKeys(formulaZ);
        String typeOfVariation = "%";
        new Select(wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='" + lineName + "'])[1]/following::select[9]"))).
                selectByVisibleText(typeOfVariation);
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='" + lineName + "'])[1]/following::input[8]")).sendKeys(marginalDeviation);
    }

    public void saveEdits() throws InterruptedException {
        click(By.xpath("//div[2]/app-button/button")); //Кнопка "Сохранить"  //app-form-input[2]/label/span[2]/input
        Thread.sleep(waitQuant);
    }
}

    /*

    public void selectGroupById(int id)
    {
        //wd.findElement(By.cssSelector("input[value='"+ id +"']")).click();
        wd.findElement(By.cssSelector(String.format("input[value='%s']", id))).click();
    }


    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));

    }

    public int count() {
        return  wd.findElements(By.name("selected[]")).size();
    }

    private Groups groupCache = null;

    public Groups allGroups() {
        if ( groupCache != null ) {
            return new Groups(groupCache);
        }
        groupCache  = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupData().withId(id).withName(name));
        }
        return new Groups(groupCache);
    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        groupCache = null;
        submitGroupModification();

    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectedGroups();
        groupCache = null;
        returnToGroupPage();
    }*/
