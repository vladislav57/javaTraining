package vladislav57.training.addressbook.tests;

import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void GroupCreationTests() {
        app.gotoGroupsPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("groupName", "groupHeader", "groupFooter"));
        app.submitGroupForm();
        app.gotoGroupsPage();
    }

}
