package vladislav57.training.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by vlad on 25.12.2016.
 */
public class TestBase {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
      wd = new FirefoxDriver();
      wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      wd.get("http://localhost/addressbook/");
      login("admin", "secret");
  }

  @AfterMethod
  public void tearDown() {
    logout();
    wd.quit();
  }

  private void login(String login, String password) {
    fillFieldByName(login, "user");
    fillFieldByName(password, "pass");
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }
  
  private void logout() {
      wd.findElement(By.linkText("Logout")).click();
  }

  protected void submitGroupForm() {
      wd.findElement(By.name("submit")).click();
  }

  protected void fillGroupForm(GroupData groupData) {
      fillFieldByName(groupData.getName(), "group_name");
      fillFieldByName(groupData.getHeader(), "group_header");
      fillFieldByName(groupData.getFooter(), "group_footer");
  }

  protected void initGroupCreation() {
      wd.findElement(By.name("new")).click();
  }

  protected void gotoGroupsPage() {
      wd.findElement(By.linkText("groups")).click();
  }

  protected void fillFieldByName(String text, String fieldName) {
      wd.findElement(By.name(fieldName)).click();
      wd.findElement(By.name(fieldName)).clear();
      wd.findElement(By.name(fieldName)).sendKeys(text);
  }

  protected void fillContactAnniversaryDate(String year) {
      if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[12]")).isSelected()) {
          wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[12]")).click();
      }
      if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[11]")).isSelected()) {
          wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[11]")).click();
      }
      fillFieldByName(year, "ayear");
  }

  protected void fillContactBirthDate(String year) {
      if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).isSelected()) {
          wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).click();
      }
      if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).isSelected()) {
          wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).click();
      }
      fillFieldByName(year, "byear");
  }

  protected void fillContactContactsData(ContactContactsData contactContactsData) {
      fillFieldByName(contactContactsData.getMobilePhone(), "mobile");
      fillFieldByName(contactContactsData.getFax(), "fax");
      fillFieldByName(contactContactsData.getEmail(), "email");
      fillFieldByName(contactContactsData.getEmail2(), "email2");
      fillFieldByName(contactContactsData.getEmail3(), "email3");
      fillFieldByName(contactContactsData.getHomepage(), "homepage");
  }

  protected void fillContactAddressData(ContactAddressData contactAddressData) {
      fillFieldByName(contactAddressData.getAddress(), "address");
      fillFieldByName(contactAddressData.getHomePhone(), "home");
  }

  protected void fillContactEmployerData(ContactEmployerData contactEmployerData) {
      fillFieldByName(contactEmployerData.getCompany(), "company");
      fillFieldByName(contactEmployerData.getWorkPhone(), "work");
  }

  protected void submitContactData() {
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  protected void gotoHomePage() {
      wd.findElement(By.linkText("home")).click();
  }

  protected void fillContactSecondaryData(ContactSecondaryData contactSecondaryData) {
      fillFieldByName(contactSecondaryData.getSecondaryAddress(), "address2");
      fillFieldByName(contactSecondaryData.getSecondaryHome(), "phone2");
      fillFieldByName(contactSecondaryData.getSecondaryNote(), "notes");
  }

  protected void fillContactNames(ContactNameData contactNameData) {
      fillFieldByName(contactNameData.getFirstName(), "firstname");
      fillFieldByName(contactNameData.getMiddleName(), "middlename");
      fillFieldByName(contactNameData.getLastName(), "lastname");
      fillFieldByName(contactNameData.getNickname(), "nickname");
      fillFieldByName(contactNameData.getTitle(), "title");
  }

  protected void initContactCreation() {
      wd.findElement(By.linkText("add new")).click();
  }

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
