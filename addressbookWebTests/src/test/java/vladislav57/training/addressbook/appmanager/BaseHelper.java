package vladislav57.training.addressbook.appmanager;

import org.openqa.selenium.*;

/**
 * Created by vlad on 25.12.2016.
 */
public class BaseHelper {
  WebDriver wd;

  public BaseHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void fillFieldByName(String text, String fieldName) {
    WebElement element = wd.findElement(By.name(fieldName));
    if(text != null && !element.getAttribute("value").equals(text))
    {
      element.click();
      element.clear();
      element.sendKeys(text);
    }
  }

  public boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
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
