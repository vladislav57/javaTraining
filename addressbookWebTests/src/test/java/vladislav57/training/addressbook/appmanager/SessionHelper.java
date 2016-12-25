package vladislav57.training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by vlad on 25.12.2016.
 */
public class SessionHelper extends BaseHelper {

  public SessionHelper(FirefoxDriver wd) {
    super(wd);
  }

  protected void login(String login, String password) {
    fillFieldByName(login, "user");
    fillFieldByName(password, "pass");
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }

  protected void logout() {
    click(By.linkText("Logout"));
  }
}
