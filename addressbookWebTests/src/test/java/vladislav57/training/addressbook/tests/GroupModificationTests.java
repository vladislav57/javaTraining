package vladislav57.training.addressbook.tests;

import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.GroupData;

/**
 * Created by vlad on 04.01.2017.
 */
public class GroupModificationTests extends TestBase{

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupsPage();
    if(app.getGroupHelper().groupListEmpty())
      app.getGroupHelper().createGroup(new GroupData("groupName", "groupHeader", "groupFooter"));
    app.getNavigationHelper().gotoGroupsPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().modifyGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("groupName", "groupHeader", "groupFooter"));
    app.getGroupHelper().submitGroupEditForm();
    app.getNavigationHelper().gotoGroupsPage();
  }
}
