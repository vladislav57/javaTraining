package vladislav57.training.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Group;

import java.util.Comparator;
import java.util.List;

/**
 * Created by vlad on 27.12.2016.
 */
public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    Group group = new Group().withName("groupName");
    int index = 1;

    app.goTo().groupsPage();
    if(app.group().groupListEmpty())
      app.group().create(group);
    app.goTo().groupsPage();
    List<Group> before = app.group().getList();
    app.group().selectGroup(index);
    app.group().deleteGroups();
    app.goTo().groupsPage();
    List<Group> after = app.group().getList();
    Assert.assertEquals(before.size(), after.size() + 1);

    before.remove(index);
    Comparator<? super Group> ById = (Comparator<Group>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    before.sort(ById);
    after.sort(ById);
    Assert.assertEquals(before, after);
  }

}
