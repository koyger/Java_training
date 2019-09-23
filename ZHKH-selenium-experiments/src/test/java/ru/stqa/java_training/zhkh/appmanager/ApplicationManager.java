package ru.stqa.java_training.zhkh.appmanager;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    public static int waitQuant = 500; // минимальный интервал ожидания во всем тест-сьюте

    private ShablonActions shablonActions;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {

        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:/Program Files/Mozilla Firefox/firefox.exe"));
            //Строка для Mac OS:  wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("/Users/koyger/Desktop/FirefoxESR/FirefoxESR.app/Contents/MacOS/firefox"));
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }
        else if (browser.equals(BrowserType.EDGE)) {
            File file = new File("C:/Users/AleksandrKoygerov/Desktop/WebDrivers/msedgedriver.exe");
            System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
            DesiredCapabilities capability = DesiredCapabilities.edge();
            capability.setBrowserName("MicrosoftEdge");
            capability.setPlatform(Platform.WIN10);
            wd = new EdgeDriver(capability);
            wd.get("http://www.google.com");


        }


        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get("https://10.77.3.140/#/login/sign-in/");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        shablonActions = new ShablonActions(wd);
        // Login
        sessionHelper.login("aleksandr.koygerov@center2m.ru", "Sport1212");
    }



    public void stop() throws Exception {

        wd.quit();
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }

    public ShablonActions shablon() {
        return shablonActions;
    }
}
