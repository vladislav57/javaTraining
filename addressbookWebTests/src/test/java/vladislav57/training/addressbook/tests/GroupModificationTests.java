package vladislav57.training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Group;
import vladislav57.training.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    Groups before = app.db().getGroups();
    Group modified = before.iterator().next();
    Group newGroup = new Group().withName("modifiedGroup").withId(modified.getId());
    app.group().modify(modified, newGroup);
    app.goTo().groupsPage();
    Groups after = app.db().getGroups();

    assertThat(after.size(), equalTo(before.size()));
    assertThat(after, equalTo(before.without(modified).withAdded(newGroup)));
  }
}
