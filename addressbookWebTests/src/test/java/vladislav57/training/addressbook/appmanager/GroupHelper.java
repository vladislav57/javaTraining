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

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index);
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

  public boolean groupListEmpty() {
    /*if(wd.findElements(By.cssSelector("[type='checkbox'][name='selected[]']")).size() == 0)
      return true;*/
    if(!isElementPresent(By.cssSelector("[type='checkbox'][name='selected[]']")))
      return true;
    return false;
  }

  public void createGroup(GroupData groupData) {
    initGroupCreation();
    fillGroupForm(groupData);
    submitGroupForm();
  }
}
