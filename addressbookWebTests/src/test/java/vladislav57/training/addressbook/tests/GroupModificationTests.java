package vladislav57.training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Group;

import java.util.Comparator;
import java.util.List;

/**
 * Created by vlad on 04.01.2017.
 */
public class GroupModificationTests extends TestBase{

  @Test
  public void testGroupModification() {
    Group group = new Group().withName("groupName");
    int index = 1;

    app.goTo().groupsPage();
    if(app.group().groupListEmpty())
      app.group().create(group);
    app.goTo().groupsPage();
    List<Group> before = app.group().getAll();
    app.group().modify(index, group);
    app.goTo().groupsPage();
    List<Group> after = app.group().getAll();
    Assert.assertEquals(before.size(), after.size());

    before.get(index).withName(group.getName());
    Comparator<? super Group> ById = (Comparator<Group>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    before.sort(ById);
    after.sort(ById);
    Assert.assertEquals(before, after);
  }
}
