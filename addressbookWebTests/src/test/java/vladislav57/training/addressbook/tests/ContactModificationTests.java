package vladislav57.training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Contact;
import vladislav57.training.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by vlad on 04.01.2017.
 */
public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    Contact contact = new Contact().withFirstName("firstName").withLastName("lastName");

    app.goTo().homePage();
    if(app.contact().listIsEmpty())
      app.contact().create(contact);
    app.goTo().homePage();
    Contacts before = app.db().getContacts();
    Contact modify = before.iterator().next();
    Contact data = new Contact().withFirstName("modified").withLastName("lastName");
    app.contact().modify(modify, data);
    app.goTo().homePage();
    Contacts after = app.db().getContacts();

    assertThat(after.size(), equalTo(before.size()));
    assertThat(after, equalTo(before.without(modify).withAdded(data.withId(modify.getId()))));
  }
}
