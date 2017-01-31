package vladislav57.training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import vladislav57.training.addressbook.model.Group;

import java.util.ArrayList;
import java.util.List;

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

  public void fillGroupForm(Group group) {
    fillFieldByName(group.getName(), "group_name");
    fillFieldByName(group.getHeader(), "group_header");
    fillFieldByName(group.getFooter(), "group_footer");
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteGroups() {
    click(By.name("delete"));
  }

  public void acceptGroupDeletion() {
    acceptAllert();
  }

  public void initModification() {
    click(By.name("edit"));
  }

  public void submitGroupEditForm() {
    click(By.name("update"));
  }

  public boolean groupListEmpty() {
    if(!isElementPresent(By.cssSelector("[type='checkbox'][name='selected[]']")))
      return true;
    return false;
  }

  public void create(Group group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupForm();
  }

  public void modify(int index, Group group) {
    selectGroup(index);
    initModification();
    fillGroupForm(group);
    submitGroupEditForm();
  }

  public List<Group> getAll() {
    List<Group> groups = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.cssSelector("[class='group']"));
    for(WebElement element : elements) {
      groups.add(new Group(Integer.parseInt(element.findElement(By.xpath("./input")).getAttribute("value")), element.getText()));
    }
    return groups;
  }
}
