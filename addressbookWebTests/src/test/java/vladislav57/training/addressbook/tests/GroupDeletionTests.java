package vladislav57.training.addressbook.tests;


import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Group;

/**
 * Created by vlad on 27.12.2016.
 */
public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.goTo().groupsPage();
    if(app.group().groupListEmpty())
      app.group().create(new Group().withName("groupName"));
    app.goTo().groupsPage();
    app.group().selectGroup(1);
    app.group().deleteGroups();
    app.goTo().groupsPage();
  }

}
