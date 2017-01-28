package vladislav57.training.addressbook.tests;

import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Group;

/**
 * Created by vlad on 04.01.2017.
 */
public class GroupModificationTests extends TestBase{

  @Test
  public void testGroupModification() {
    app.goTo().groupsPage();
    if(app.group().groupListEmpty())
      app.group().create(new Group().withName("groupName"));
    app.goTo().groupsPage();
    app.group().modify(1, new Group().withName("groupName"));
    app.goTo().groupsPage();
  }
}
