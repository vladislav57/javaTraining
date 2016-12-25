package vladislav57.training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by vlad on 25.12.2016.
 */
public class NavigationHelper {
  FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void gotoGroupsPage() {
      wd.findElement(By.linkText("groups")).click();
  }

  public void gotoHomePage() {
      wd.findElement(By.linkText("home")).click();
  }
}
