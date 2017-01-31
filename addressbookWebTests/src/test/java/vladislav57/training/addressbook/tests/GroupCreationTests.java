package vladislav57.training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Contact;
import vladislav57.training.addressbook.model.Group;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        Group group = new Group().withName("groupName");

        app.goTo().groupsPage();
        List<Group> before = app.group().getAll();
        app.group().create(group);
        app.goTo().groupsPage();
        List<Group> after = app.group().getAll();
        Assert.assertEquals(before.size() + 1, after.size());

        before.add(group);
        Comparator<? super Group> ById = (Comparator<Group>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before, after);
    }

}
