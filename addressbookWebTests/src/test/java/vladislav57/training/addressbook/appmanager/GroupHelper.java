package vladislav57.training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import vladislav57.training.addressbook.model.GroupData;

/**
 * Created by vlad on 25.12.2016.
 */
public class GroupHelper extends BaseHelper {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void submitGroupForm() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    fillFieldByName(groupData.getName(), "group_name");
    fillFieldByName(groupData.getHeader(), "group_header");
    fillFieldByName(groupData.getFooter(), "group_footer");
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void deleteGroups() {
    click(By.name("delete"));
  }

  public void acceptGroupDeletion() {
    acceptAllert();
  }

  public void modifyGroup() {
    click(By.name("edit"));
  }

  public void submitGroupEditForm() {
    click(By.name("update"));
  }
}
