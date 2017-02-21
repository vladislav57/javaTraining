package vladislav57.training.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by vlad on 21.02.2017.
 */
public class BrowserHelper extends BaseHelper {
  public BrowserHelper(ApplicationManager app) {
    super(app);
  }

  public void login(String login, String password) {
    wd.get(app.getProperty("url") + "/login_page.php");
    fillFieldByName(login, "username");
    fillFieldByName(password, "password");
    click(By.cssSelector("input[value='Войти']"));
  }

  public String selectNonAdminUser(String adminLogin) {
    List<WebElement> list = wd.findElements(By.xpath("//tbody//a"));
    WebElement user = list.stream().filter((e) -> !e.getText().equals(adminLogin)).findAny().get();
    user.click();
    return user.getText();
  }

  public void resetUserPassword() {
    click(By.cssSelector("input[value='Сбросить пароль']"));
  }

  public void setNewPassword(String link, String newPass) {
    wd.get(link);
    fillFieldByName(newPass, "password");
    fillFieldByName(newPass, "password_confirm");
    click(By.cssSelector("button[type='submit']"));
  }

  public boolean isLogedIn(String username) {
    if(wd.findElement(By.cssSelector("span[class='user-info']")).getText().equals(username))
      return true;
    return false;
  }
}
