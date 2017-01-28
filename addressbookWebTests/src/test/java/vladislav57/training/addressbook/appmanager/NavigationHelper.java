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

  public void homePage() {
    if( !isElementPresent(By.id("maintable")))
      click(By.linkText("home"));
  }

  public void groupsPage() {
    if(isElementPresent(By.tagName("h1"))) {
      if ( wd.findElement(By.tagName("h1")).getText().equals("Groups") && isElementPresent(By.name("new")))
        return;
    }
    click(By.linkText("groups"));
  }
}
