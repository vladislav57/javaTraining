package vladislav57.training.mantis.tests;

import org.testng.annotations.Test;
import vladislav57.training.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by vlad on 19.02.2017.
 */
public class LoginTests extends TestBase{

  @Test
  public void testLogin() throws IOException {
    HttpSession session = app.newSession();
    assertTrue(session.login("user", "test2"));
    assertTrue(session.isLoggedInAs("user"));
  }
}
