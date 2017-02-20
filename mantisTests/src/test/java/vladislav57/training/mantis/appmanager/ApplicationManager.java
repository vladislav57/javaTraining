package vladislav57.training.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by vlad on 25.12.2016.
 */
public class ApplicationManager {
  WebDriver wd;
  Properties properties;
  String browser;
  private RegistrationHelper registrationHelper;
  private BrowserHelper browserHelper;
  private MailHelper mailHelper;
  private NavigationHelper navigationHelper;

  public ApplicationManager(String browser) {
    properties = new Properties();
    this.browser = browser;
  }

  public void init() throws Exception {

    String target = System.getProperty("target", "default");
    properties.load(new FileReader(new File("src/test/resources/" + target + ".properties")));

  }

  public void stop() {
    if(wd != null)
      wd.quit();
  }

  public HttpSession newSession() {
    return new HttpSession(this);
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }

  public RegistrationHelper registration() {
    if(registrationHelper == null) {
      registrationHelper = new RegistrationHelper(this);
    }
    return registrationHelper;
  }

  public BrowserHelper web() {
    if(browserHelper == null) {
      browserHelper = new BrowserHelper(this);
    }
    return browserHelper;
  }

  public NavigationHelper goTo() {
    if(navigationHelper == null) {
      navigationHelper = new NavigationHelper(this);
    }
    return navigationHelper;
  }

  public MailHelper mail() {
    if(mailHelper == null) {
      mailHelper = new MailHelper(this);
    }
    return mailHelper;
  }

  public WebDriver getDriver() {

    if(wd == null) {
      if(browser.equals(BrowserType.CHROME)) {
        wd = new ChromeDriver();
      } else if (browser.equals(BrowserType.FIREFOX)) {
        wd = new FirefoxDriver();
      } else if (browser.equals(BrowserType.IEXPLORE)) {
        wd = new InternetExplorerDriver();
      }
      wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
      wd.get(properties.getProperty("url"));
    }

    return wd;
  }
}
