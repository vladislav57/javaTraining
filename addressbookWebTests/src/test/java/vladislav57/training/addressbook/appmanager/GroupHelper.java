package vladislav57.training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import vladislav57.training.addressbook.model.GroupData;

/**
 * Created by vlad on 25.12.2016.
 */
public class GroupHelper {
  private FirefoxDriver wd;

  public GroupHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void submitGroupForm() {
      wd.findElement(By.name("submit")).click();
  }

  public void fillGroupForm(GroupData groupData) {
      fillFieldByName(groupData.getName(), "group_name");
      fillFieldByName(groupData.getHeader(), "group_header");
      fillFieldByName(groupData.getFooter(), "group_footer");
  }

  public void initGroupCreation() {
      wd.findElement(By.name("new")).click();
  }

  public void fillFieldByName(String text, String fieldName) {
      wd.findElement(By.name(fieldName)).click();
      wd.findElement(By.name(fieldName)).clear();
      wd.findElement(By.name(fieldName)).sendKeys(text);
  }
}
