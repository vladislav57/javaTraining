package vladislav57.training.addressbook.tests;


import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Group;

/**
 * Created by vlad on 27.12.2016.
 */
public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupsPage();
    if(app.getGroupHelper().groupListEmpty())
      app.getGroupHelper().createGroup(new Group("groupName", "groupHeader", "groupFooter"));
    app.getNavigationHelper().gotoGroupsPage();
    app.getGroupHelper().selectGroup(1);
    app.getGroupHelper().deleteGroups();
    //app.getGroupHelper().acceptGroupDeletion();
    app.getNavigationHelper().gotoGroupsPage();
  }

}
