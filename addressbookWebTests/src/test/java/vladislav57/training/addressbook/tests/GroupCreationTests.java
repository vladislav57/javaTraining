package vladislav57.training.addressbook.tests;

import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Group;
import vladislav57.training.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    Group group = new Group().withName("groupName");

    app.goTo().groupsPage();
    Groups before = app.group().getAll();
    app.group().create(group);
    app.goTo().groupsPage();
    Groups after = app.group().getAll();
    assertThat(before.size() + 1, equalTo(after.size()));

    after.stream().mapToInt( o -> o.getId()).max().getAsInt();
    assertThat(after, equalTo(before.withAdded()));
  }

}
