package vladislav57.training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by vlad on 25.12.2016.
 */
public class BaseHelper {
  WebDriver wd;

  public BaseHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void fillFieldByName(String text, String fieldName) {
    wd.findElement(By.name(fieldName)).click();
    wd.findElement(By.name(fieldName)).clear();
    wd.findElement(By.name(fieldName)).sendKeys(text);
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void fillDate(String year, By dayLocator, By monthLocator, String yearFieldName) {
    pickDropdownItem(dayLocator);
    pickDropdownItem(monthLocator);
    fillFieldByName(year, yearFieldName);
  }

  private void pickDropdownItem(By dayLocator) {
    if (!wd.findElement(dayLocator).isSelected()) {
      click(dayLocator);
    }
  }

  public static boolean isAlertPresent(WebDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected void selectElement(String id) {
    if(!wd.findElement(By.id(id)).isSelected()) {
      click(By.id(id));
    }
  }

  protected void acceptAllert() {
    wd.switchTo().alert().accept();
  }
}
