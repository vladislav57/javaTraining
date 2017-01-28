package vladislav57.training.addressbook.tests;

import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Group;

/**
 * Created by vlad on 04.01.2017.
 */
public class GroupModificationTests extends TestBase{

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupsPage();
    if(app.getGroupHelper().groupListEmpty())
      app.getGroupHelper().createGroup(new Group("groupName", "groupHeader", "groupFooter"));
    app.getNavigationHelper().gotoGroupsPage();
    app.getGroupHelper().modifyGroup(1, new Group("groupName", "groupHeader", "groupFooter"));
    app.getNavigationHelper().gotoGroupsPage();
  }
}
