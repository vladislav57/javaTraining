package vladislav57.training.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class GroupCreationTests {
    FirefoxDriver wd;

    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }
    
    @Test
    public void GroupCreationTests() {
        gotoGroupsPage();
        initializeNewGroupCreation();
        fillGroupForm(new GroupData("groupName", "groupHeader", "groupFooter"));
        submitGroupForm();
        gotoGroupsPage();
    }

    private void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }

    private void submitGroupForm() {
        wd.findElement(By.name("submit")).click();
    }

    private void fillGroupForm(GroupData groupData) {
        fillFieldByName(groupData.getName(), "group_name");
        fillFieldByName(groupData.getHeader(), "group_header");
        fillFieldByName(groupData.getFooter(), "group_footer");
    }

    private void initializeNewGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    private void gotoGroupsPage() {
        wd.findElement(By.linkText("groups")).click();
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
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
