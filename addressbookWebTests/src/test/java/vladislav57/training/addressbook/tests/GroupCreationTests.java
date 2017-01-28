package vladislav57.training.addressbook.tests;

import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Group;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new Group("groupName", "groupHeader", "groupFooter"));
        app.getGroupHelper().submitGroupForm();
        app.getNavigationHelper().gotoGroupsPage();
    }

}
