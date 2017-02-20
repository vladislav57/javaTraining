package vladislav57.training.mantis.appmanager;

/**
 * Created by vlad on 21.02.2017.
 */
public class NavigationHelper extends BaseHelper {
  public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void adminUsersPanel() {
    wd.get(app.getProperty("url") + "/manage_user_page.php");
  }
}
