package vladislav57.training.addressbook.tests;

import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Group;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupsPage();
        app.group().create(new Group().withName("groupName"));
        app.goTo().groupsPage();
    }

}
