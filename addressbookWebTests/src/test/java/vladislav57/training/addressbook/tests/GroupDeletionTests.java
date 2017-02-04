package vladislav57.training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Group;
import vladislav57.training.addressbook.model.Groups;

import java.util.Comparator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    Groups before = app.group().getAll();
    Group group = before.iterator().next();
    app.group().delete(group);
    app.goTo().groupsPage();
    Groups after = app.group().getAll();

    assertThat(after.size(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.without(group)));
  }

}
