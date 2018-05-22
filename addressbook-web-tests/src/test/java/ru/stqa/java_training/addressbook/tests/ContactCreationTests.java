package ru.stqa.java_training.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {
    /*FirefoxDriver wd;

    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("/Users/koyger/Desktop/FirefoxESR/FirefoxESR.app/Contents/MacOS/firefox"));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


        login("admin", "secret");
    }

    private void login(String login, String password) {
        wd.get("http://localhost/addressbook/edit.php");
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(login);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
    }*/

    @Test
    public void testContactCreation() {

        app.getNavigationHelper().gotoNewContactPage();
        app.getContactHelper().fillContactForm(new ContactData("Petr", "Petrovich", "PetroFF", "petrishchev", "Mr.", "Petrosoft", "Теперь двухзвенные классы", "+1 999 999 99 99", "petr@gmail.com", "petr@petrosoft.com", "petrov.petrosoft.com", "Notes For Petrov"));
        app.getContactHelper().submitContactForm();
        app.getContactHelper().returnToContactsPage();

        //returnToContactsPage();
    }

    /*private void returnToContactsPage() {
        wd.findElement(By.linkText("home")).click();
    }

    private void submitConactForm() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    private void fillContactForm(ContactData contactData) {






        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(contactData.getPhone());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactData.getFirstEmail());
        wd.findElement(By.name("email2")).click();
        wd.findElement(By.name("email2")).clear();
        wd.findElement(By.name("email2")).sendKeys(contactData.getSecondEmail());
        wd.findElement(By.name("homepage")).click();
        wd.findElement(By.name("homepage")).clear();
        wd.findElement(By.name("homepage")).sendKeys(contactData.getHomePage());
        wd.findElement(By.name("notes")).click();
        wd.findElement(By.name("notes")).clear();
        wd.findElement(By.name("notes")).sendKeys(contactData.getNotes());
    }

    private void gotoNewContactPage() {
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }*/
}
