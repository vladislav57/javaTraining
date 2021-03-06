package vladislav57.training.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import vladislav57.training.mantis.appmanager.HttpSession;
import vladislav57.training.mantis.model.MailMessage;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by vlad on 20.02.2017.
 */
public class changePasswordTests extends TestBase{

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testChangePassword() throws IOException {

    String username;
    String new_pass = "test2";
    String adminLogin = "administrator";
    String adminPassword = "admin";

    app.web().login(adminLogin, adminPassword);
    app.goTo().adminUsersPanel();
    username = app.web().selectNonAdminUser(adminLogin);
    app.web().resetUserPassword();

    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String resetPasswordLink = findResetPasswordLink(mailMessages.get(0));
    app.web().setNewPassword(resetPasswordLink, new_pass);
    HttpSession session = app.newSession();
    assertTrue(session.login(username, new_pass));
    assertTrue(session.isLoggedInAs(username));
  }

  private String findResetPasswordLink(MailMessage mailMessage) {
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}
