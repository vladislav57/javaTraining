package vladislav57.training.addressbook.tests;

import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Contact;
import vladislav57.training.addressbook.model.Group;
import vladislav57.training.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by vlad on 15.02.2017.
 */
public class ContactGroupAssignmentTests extends TestBase {

  @Test
  public void testContactToGroupAssignment() {
    /*если групп нет - добавляем группу*/
    if (app.db().getGroups().size() == 0) {
      app.goTo().groupsPage();
      app.group().create(new Group().withName("assignTestGroup"));
    }
    Groups initialGroups = app.db().getGroups();

    /*если нет контактов или нет ни одного контакта, который можно добавить в группу, - создаем контакт*/
    if (app.db().getContacts().size() == 0 ||
            app.db().getContacts().stream().filter((c) -> !c.getGroups().equals(initialGroups)).count() == 0) {
      app.goTo().homePage();
      app.contact().create(new Contact().withLastName("assignTestLastName").withFirstName("assignTestFirstName"));
    }
    Contact testContact = app.db().getContacts().stream()
            .filter((c) -> !c.getGroups().equals(initialGroups)).iterator().next();
    Group testGroup = app.db().getGroups().stream()
            .filter((g) -> !testContact.getGroups().contains(g)).iterator().next();
    Groups before = testContact.getGroups();
    app.goTo().homePage();
    app.contact().addToGroup(testContact, testGroup);
    Groups after = app.db().getContacts().stream().filter((c) -> c.equals(testContact)).iterator().next().getGroups();
    assertThat(before.withAdded(testGroup), equalTo(after));
  }

  @Test
  public void testDeassignContactFromGroup() {
    Contact testContact;
    Group testGroup;

    /*если групп нет - добавляем группу*/
    if (app.db().getGroups().size() == 0) {
      app.goTo().groupsPage();
      app.group().create(new Group().withName("deassignTestGroup"));
    }

    /*если нет контактов - создаем контакт*/
    if (app.db().getContacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new Contact().withLastName("deassignTestLastName").withFirstName("deassignTestFirstName"));
    }

    /*если нет ни одного контакта, который входит в какую-либо группу - добавляем контакт в группу*/
    /*иначе - выбираем контакт, добавленный в группу*/
    if (app.db().getContacts().stream().filter((c) -> (c.getGroups().size() > 0) ).count() == 0) {
      testContact = app.db().getContacts().iterator().next();
      testGroup = app.db().getGroups().iterator().next();
      app.goTo().homePage();
      app.contact().addToGroup(testContact, testGroup);
    } else {
      testContact = app.db().getContacts().stream().filter((c) -> (c.getGroups().size() > 0)).iterator().next();
      testGroup = testContact.getGroups().iterator().next();
    }

    Groups before = app.db().getContacts().stream().filter((c) -> c.equals(testContact)).iterator().next().getGroups();
    app.goTo().homePage();
    app.contact().filterContactsByGroup(testGroup);
    app.contact().removeFromGroup(testContact, testGroup);
    Groups after = app.db().getContacts().stream().filter((c) -> c.equals(testContact)).iterator().next().getGroups();
    assertThat(before.without(testGroup), equalTo(after));
  }

}
