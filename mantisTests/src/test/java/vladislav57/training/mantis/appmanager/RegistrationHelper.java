package vladislav57.training.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by vlad on 19.02.2017.
 */
public class RegistrationHelper extends BaseHelper{

  public RegistrationHelper(ApplicationManager app) {
    super(app);
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("url") + "/signup_page.php");
    fillFieldByName(username, "username");
    fillFieldByName(email, "email");
    click(By.cssSelector("input[value='Зарегистрироваться']"));
  }
}
