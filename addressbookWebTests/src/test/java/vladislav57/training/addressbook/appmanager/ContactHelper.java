package vladislav57.training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import vladislav57.training.addressbook.model.*;

/**
 * Created by vlad on 25.12.2016.
 */
public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactAnniversaryDate(String year) {
    fillDate(year, By.xpath("//div[@id='content']/form/select[3]//option[12]"), By.xpath("//div[@id='content']/form/select[4]//option[11]"), "ayear");
  }

  public void fillContactBirthDate(String year) {
    fillDate(year, By.xpath("//div[@id='content']/form/select[1]//option[3]"), By.xpath("//div[@id='content']/form/select[2]//option[2]"), "byear");
  }

  public void fillContactNames(Contact contact) {
    fillFieldByName(contact.getFirstName(), "firstname");
    fillFieldByName(contact.getMiddleName(), "middlename");
    fillFieldByName(contact.getLastName(), "lastname");
    fillFieldByName(contact.getNickname(), "nickname");
    fillFieldByName(contact.getTitle(), "title");
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact(int index) {
    wd.findElements(By.cssSelector("[id][type='checkbox'][name='selected[]']")).get(index).click();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//*[@id='content']/form[2]/div[2]/input"));
  }

  public void acceptContactDeletion() {
    acceptAllert();
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactCreateData() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void submitContactEditData() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

  public boolean contactListEmpty() {
    if(wd.findElements(By.cssSelector("[id][type='checkbox'][name='selected[]']")).size() == 0)
      return true;
    return false;
  }

  public void createNewContact(Contact nameData) {
    initContactCreation();
    fillContactNames(nameData);
    submitContactCreateData();
  }

  public void modify(int index, Contact data) {
    selectContact(index);
    initContactModification();
    fillContactNames(data);
    submitContactEditData();
  }
}
