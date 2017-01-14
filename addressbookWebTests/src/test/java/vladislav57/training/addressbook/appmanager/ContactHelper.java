package vladislav57.training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

  public void fillContactContactsData(ContactContactsData contactContactsData) {
    fillFieldByName(contactContactsData.getMobilePhone(), "mobile");
    fillFieldByName(contactContactsData.getFax(), "fax");
    fillFieldByName(contactContactsData.getEmail(), "email");
    fillFieldByName(contactContactsData.getEmail2(), "email2");
    fillFieldByName(contactContactsData.getEmail3(), "email3");
    fillFieldByName(contactContactsData.getHomepage(), "homepage");
  }

  public void fillContactAddressData(ContactAddressData contactAddressData) {
    fillFieldByName(contactAddressData.getAddress(), "address");
    fillFieldByName(contactAddressData.getHomePhone(), "home");
  }

  public void fillContactEmployerData(ContactEmployerData contactEmployerData) {
    fillFieldByName(contactEmployerData.getCompany(), "company");
    fillFieldByName(contactEmployerData.getWorkPhone(), "work");
  }

  public void fillContactSecondaryData(ContactSecondaryData contactSecondaryData) {
    fillFieldByName(contactSecondaryData.getSecondaryAddress(), "address2");
    fillFieldByName(contactSecondaryData.getSecondaryHome(), "phone2");
    fillFieldByName(contactSecondaryData.getSecondaryNote(), "notes");
  }

  public void fillContactNames(ContactNameData contactNameData) {
    fillFieldByName(contactNameData.getFirstName(), "firstname");
    fillFieldByName(contactNameData.getMiddleName(), "middlename");
    fillFieldByName(contactNameData.getLastName(), "lastname");
    fillFieldByName(contactNameData.getNickname(), "nickname");
    fillFieldByName(contactNameData.getTitle(), "title");
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
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
}
