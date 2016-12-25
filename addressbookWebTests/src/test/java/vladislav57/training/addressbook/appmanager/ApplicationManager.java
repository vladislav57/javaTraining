package vladislav57.training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by vlad on 25.12.2016.
 */
public class ApplicationManager {
  FirefoxDriver wd;

  private NavigationHelper navigationHelper;
  private ContactHelper contactHelper;
  private GroupHelper groupHelper;

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    groupHelper = new GroupHelper(wd);
    contactHelper = new ContactHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    login("admin", "secret");
  }

  public void stop() {
    logout();
    wd.quit();
  }

  private void login(String login, String password) {
    fillFieldByName(login, "user");
    fillFieldByName(password, "pass");
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  private void logout() {
      wd.findElement(By.linkText("Logout")).click();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public void fillFieldByName(String text, String fieldName) {
    wd.findElement(By.name(fieldName)).click();
    wd.findElement(By.name(fieldName)).clear();
    wd.findElement(By.name(fieldName)).sendKeys(text);
  }
}
