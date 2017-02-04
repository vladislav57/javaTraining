package vladislav57.training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import vladislav57.training.addressbook.model.Contact;
import vladislav57.training.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.List;

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

  public void fillContactData(Contact contact) {
    fillFieldByName(contact.getFirstName(), "firstname");
    fillFieldByName(contact.getMiddleName(), "middlename");
    fillFieldByName(contact.getLastName(), "lastname");
    fillFieldByName(contact.getNickname(), "nickname");
    fillFieldByName(contact.getTitle(), "title");
  }

  public void initCreation() {
    click(By.linkText("add new"));
  }

  public void select(int index) {
    wd.findElements(By.cssSelector("[id][type='checkbox'][name='selected[]']")).get(index).click();
  }

  public void deleteSelected() {
    click(By.xpath("//*[@id='content']/form[2]/div[2]/input"));
  }

  public void acceptDeletion() {
    acceptAllert();
  }

  public void initContactModification(Contact modify) {
    click(By.xpath("//a[@href='edit.php?id=" + modify.getId() + "']"));
  }

  public void submitCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void submitEdit() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

  public boolean listIsEmpty() {
    if(wd.findElements(By.cssSelector("[id][type='checkbox'][name='selected[]']")).size() == 0)
      return true;
    return false;
  }

  public void create(Contact contact) {
    initCreation();
    fillContactData(contact);
    submitCreation();
  }

  public void modify(Contact modify, Contact data) {
    initContactModification(modify);
    fillContactData(data);
    submitEdit();
  }

  public void delete(Contact contact) {
    select(contact);
    deleteSelected();
    acceptDeletion();
  }

  private void select(Contact contact) {
    wd.findElement(By.cssSelector("[id='" + contact.getId() + "'][type='checkbox'][name='selected[]']")).click();
  }

  public Contacts getAll() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.cssSelector("[name='entry']"));
    for(WebElement element : elements) {
      contacts.add(new Contact(Integer.parseInt(element.findElement(By.xpath("./td[1]/input")).getAttribute("id")), element.findElement(By.xpath("./td[3]")).getText(), element.findElement(By.xpath("./td[2]")).getText()));
    }
    return contacts;
  }
}
