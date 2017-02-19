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

  public ApplicationManager() {
    properties = new Properties();
  }

  public void init(String browser) throws Exception {

    if(browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.IEXPLORE)) {
      wd = new InternetExplorerDriver();
    }

    String target = System.getProperty("target", "default");
    properties.load(new FileReader(new File("src/test/resources/" + target + ".properties")));
    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    wd.get(properties.getProperty("url"));

  }

  public void stop() {
    wd.quit();
  }

}
