package vladislav57.training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import vladislav57.training.addressbook.model.*;

/**
 * Created by vlad on 25.12.2016.
 */
public class ContactHelper {
  FirefoxDriver wd;

  public ContactHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void fillContactAnniversaryDate(String year) {
      if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[12]")).isSelected()) {
          wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[12]")).click();
      }
      if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[11]")).isSelected()) {
          wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[11]")).click();
      }
      fillFieldByName(year, "ayear");
  }

  public void fillContactBirthDate(String year) {
      if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).isSelected()) {
          wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).click();
      }
      if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).isSelected()) {
          wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).click();
      }
      fillFieldByName(year, "byear");
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

  public void submitContactData() {
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
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
      wd.findElement(By.linkText("add new")).click();
  }

  public void fillFieldByName(String text, String fieldName) {
    wd.findElement(By.name(fieldName)).click();
    wd.findElement(By.name(fieldName)).clear();
    wd.findElement(By.name(fieldName)).sendKeys(text);
  }
}
