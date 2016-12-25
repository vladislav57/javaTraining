package vladislav57.training.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void GroupCreationTests() {
        gotoGroupsPage();
        initGroupCreation();
        fillGroupForm(new GroupData("groupName", "groupHeader", "groupFooter"));
        submitGroupForm();
        gotoGroupsPage();
    }

}
