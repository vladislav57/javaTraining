package vladislav57.training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import vladislav57.training.addressbook.model.Group;
import vladislav57.training.addressbook.model.Groups;

import java.util.List;

/**
 * Created by vlad on 25.12.2016.
 */
public class GroupHelper extends BaseHelper {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void fillForm(Group group) {
    fillFieldByName(group.getName(), "group_name");
    fillFieldByName(group.getHeader(), "group_header");
    fillFieldByName(group.getFooter(), "group_footer");
  }

  public void create() {
    click(By.name("new"));
  }

  public void delete() {
    click(By.name("delete"));
  }

  public void modify() {
    click(By.name("edit"));
  }

  public void submitEdit() {
    click(By.name("update"));
  }

  public void submitForm() {
    click(By.name("submit"));
  }

  public boolean groupListEmpty() {
    if(!isElementPresent(By.cssSelector("[type='checkbox'][name='selected[]']")))
      return true;
    return false;
  }

  public void create(Group group) {
    create();
    fillForm(group);
    submitForm();
  }

  public void modify(Group modify, Group data) {
    selectGroup(modify);
    modify();
    fillForm(data);
    submitEdit();
  }

  public void delete(Group group) {
    selectGroup(group);
    delete();
  }

  private void selectGroup(Group group) {
    wd.findElement(By.cssSelector("[type='checkbox'][name='selected[]'][value='" + group.getId() + "']")).click();
  }

  public Groups getAll() {
    Groups groups = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("[class='group']"));
    for(WebElement element : elements) {
      groups.add(new Group(Integer.parseInt(element.findElement(By.xpath("./input")).getAttribute("value")), element.getText()));
    }
    return groups;
  }
}
