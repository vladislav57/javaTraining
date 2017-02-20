package vladislav57.training.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vladislav57.training.mantis.model.MailMessage;

import java.util.List;

/**
 * Created by vlad on 19.02.2017.
 */
public class RegistrationTests extends TestBase{

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testRegistration() {
    String username = "user";
    String email = "user@localhost.localdomain";
    app.registration().start(username, email);
    List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}
