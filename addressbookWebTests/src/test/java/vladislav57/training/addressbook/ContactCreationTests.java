package vladislav57.training.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class ContactCreationTests {
    FirefoxDriver wd;

    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }
    
    @Test
    public void ContactCreationTests() {
        initContactCreation();
        fillContactNames(new ContactNameData("firstName", "middleName", "lastName", "nickname", "title"));
        fillContactEmployerData(new ContactEmployerData("company", "workPhone"));
        fillContactAddressData(new ContactAddressData("address", "homePhome"));
        fillContactContactsData(new ContactContactsData("mobilePhone", "fax", "e-mail", "e-mail2", "e-mail3", "homepage"));
        fillContactBirthDate("1990");
        fillContactAnniversaryDate("2010");
        fillContactSecondaryData(new ContactSecondaryData("address2", "phone2", "notes"));
        submitContactData();
        gotoHomePage();
    }

    private void fillContactAnniversaryDate(String year) {
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[12]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[12]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[11]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[11]")).click();
        }
        fillFieldByName(year, "ayear");
    }

    private void fillContactBirthDate(String year) {
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).click();
        }
        fillFieldByName(year, "byear");
    }

    private void fillContactContactsData(ContactContactsData contactContactsData) {
        fillFieldByName(contactContactsData.getMobilePhone(), "mobile");
        fillFieldByName(contactContactsData.getFax(), "fax");
        fillFieldByName(contactContactsData.getEmail(), "email");
        fillFieldByName(contactContactsData.getEmail2(), "email2");
        fillFieldByName(contactContactsData.getEmail3(), "email3");
        fillFieldByName(contactContactsData.getHomepage(), "homepage");
    }

    private void fillContactAddressData(ContactAddressData contactAddressData) {
        fillFieldByName(contactAddressData.getAddress(), "address");
        fillFieldByName(contactAddressData.getHomePhone(), "home");
    }

    private void fillContactEmployerData(ContactEmployerData contactEmployerData) {
        fillFieldByName(contactEmployerData.getCompany(), "company");
        fillFieldByName(contactEmployerData.getWorkPhone(), "work");
    }

    private void submitContactData() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    private void gotoHomePage() {
        wd.findElement(By.linkText("home")).click();
    }

    private void fillContactSecondaryData(ContactSecondaryData contactSecondaryData) {
        fillFieldByName(contactSecondaryData.getSecondaryAddress(), "address2");
        fillFieldByName(contactSecondaryData.getSecondaryHome(), "phone2");
        fillFieldByName(contactSecondaryData.getSecondaryNote(), "notes");
    }

    private void fillContactNames(ContactNameData contactNameData) {
        fillFieldByName(contactNameData.getFirstName(), "firstname");
        fillFieldByName(contactNameData.getMiddleName(), "middlename");
        fillFieldByName(contactNameData.getLastName(), "lastname");
        fillFieldByName(contactNameData.getNickname(), "nickname");
        fillFieldByName(contactNameData.getTitle(), "title");
    }

    private void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }

    private void login(String login, String password) {
        fillFieldByName(login, "user");
        fillFieldByName(password, "pass");
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    private void fillFieldByName(String text, String fieldName) {
        wd.findElement(By.name(fieldName)).click();
        wd.findElement(By.name(fieldName)).clear();
        wd.findElement(By.name(fieldName)).sendKeys(text);
    }

    @AfterMethod
    public void tearDown() {
        logout();
        wd.quit();
    }
}
