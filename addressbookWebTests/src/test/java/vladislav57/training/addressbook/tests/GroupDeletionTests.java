package vladislav57.training.addressbook.tests;


import org.testng.annotations.Test;

/**
 * Created by vlad on 27.12.2016.
 */
public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupsPage();
    if(app.getGroupHelper().groupListEmpty())
      app.getGroupHelper().createGroup();
    app.getNavigationHelper().gotoGroupsPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteGroups();
    //app.getGroupHelper().acceptGroupDeletion();
    app.getNavigationHelper().gotoGroupsPage();
  }

}
