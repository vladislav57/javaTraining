package vladislav57.training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import vladislav57.training.addressbook.model.Contact;
import vladislav57.training.addressbook.model.Contacts;

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
    fillFieldByName(contact.getHomePhone(), "home");
    fillFieldByName(contact.getMobilePhone(), "mobile");
    fillFieldByName(contact.getWorkPhone(), "work");
    fillFieldByName(contact.getEmail1(), "email");
    fillFieldByName(contact.getEmail2(), "email2");
    fillFieldByName(contact.getEmail3(), "email3");
    fillFieldByName(contact.getAddress(), "address");
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

  public void openEditPage(Contact contact) {
    click(By.xpath("//a[@href='edit.php?id=" + contact.getId() + "']"));
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
    openEditPage(modify);
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
      int id = Integer.parseInt(element.findElement(By.xpath("./td[1]/input")).getAttribute("id"));
      String firstName = element.findElement(By.xpath("./td[3]")).getText();
      String lastName = element.findElement(By.xpath("./td[2]")).getText();
      String allPhones = element.findElement(By.xpath("./td[6]")).getText();
      String allEmails = element.findElement(By.xpath("./td[5]")).getText();
      String address = element.findElement(By.xpath("./td[4]")).getText();
      contacts.add(new Contact().withId(id).withFirstName(firstName).withLastName(lastName)
              .withPhones(allPhones).withEmails(allEmails).withAddress(address));
    }
    return contacts;
  }

  public Contact getInfoFromEditPage(Contact contact) {
    openEditPage(contact);
    String firstName = wd.findElement(By.cssSelector("[name='firstname']")).getAttribute("value");
    String lastName  = wd.findElement(By.cssSelector("[name='lastname']")).getAttribute("value");
    String middleName = wd.findElement(By.cssSelector("[name='middlename']")).getAttribute("value");
    String homePhone = wd.findElement(By.cssSelector("[name='home']")).getAttribute("value");
    String workPhone = wd.findElement(By.cssSelector("[name='work']")).getAttribute("value");
    String mobilePhone = wd.findElement(By.cssSelector("[name='mobile']")).getAttribute("value");
    String mail1 = wd.findElement(By.cssSelector("[name='email']")).getAttribute("value");
    String mail2 = wd.findElement(By.cssSelector("[name='email2']")).getAttribute("value");
    String mail3 = wd.findElement(By.cssSelector("[name='email3']")).getAttribute("value");
    String address = wd.findElement(By.cssSelector("[name='address']")).getAttribute("value");
    Contact info = new Contact().withFirstName(firstName).withLastName(lastName)
            .withHomePhone(homePhone).withMobilePhone(mobilePhone).withWorkPhone(workPhone)
            .withEmail1(mail1).withEmail2(mail2).withEmail3(mail3).withAddress(address);
    return info;
  }

  public Contact getInfoFromDetailsPage(Contact contact) {
    openDetailsPage(contact);
    //String names = wd.findElement(By.xpath("//div[@id='content']/b")).getText();
    String mail1 = wd.findElement(By.xpath("//a[@href='mailto:mail1']")).getText();
    String mail2 = wd.findElement(By.xpath("//a[@href='mailto:mail2']")).getText();
    String mail3 = wd.findElement(By.xpath("//a[@href='mailto:mail3']")).getText();
    String[] data  = wd.findElement(By.xpath("//div[@id='content']")).getText().split("\n");
    String[] names = data[0].split(" ");
    String homePhone = data[3].replace("H: ", "");
    String mobilePhone = data[4].replace("M: ", "");
    String workPhone = data[5].replace("W: ", "");
    String address = data[1];
    Contact info = new Contact().withFirstName(names[0]).withLastName(names[1])
            .withHomePhone(homePhone).withMobilePhone(mobilePhone).withWorkPhone(workPhone)
            .withEmail1(mail1).withEmail2(mail2).withEmail3(mail3).withAddress(address);
    return info;
  }

  private void openDetailsPage(Contact contact) {
    click(By.xpath("//a[@href='view.php?id=" + contact.getId() + "']"));
  }
}
