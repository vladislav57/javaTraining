package vladislav57.training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by vlad on 25.12.2016.
 */
public class NavigationHelper extends BaseHelper {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupsPage() {
    click(By.linkText("groups"));
  }

  public void gotoHomePage() {
    click(By.linkText("home"));
  }
}
