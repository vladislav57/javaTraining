package vladislav57.training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    try {
      WebDriverWait wait = new WebDriverWait(wd, 1);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='content']/h1")));
      WebElement header = wd.findElement(By.xpath("//div[@id='content']/h1"));
      if (header.getText().equals("Groups") && isElementPresent(By.name("new")))
        return;
    } catch (Exception e) {}
    click(By.linkText("groups"));
  }
}
