package vladislav57.training.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import vladislav57.training.addressbook.appmanager.ApplicationManager;

/**
 * Created by vlad on 25.12.2016.
 */

public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager();

  @BeforeSuite
  public void setUp() throws Exception {
    app.init(System.getProperty("browser", BrowserType.FIREFOX));
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }

}
