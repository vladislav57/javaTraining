package vladislav57.training.addressbook.tests;

import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Contact;
import vladislav57.training.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    Contact contact = new Contact().withFirstName("firstName").withLastName("lastName");

    app.goTo().homePage();
    Contacts before = app.contact().getAll();
    app.contact().create(contact);
    app.goTo().homePage();
    Contacts after = app.contact().getAll();

    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt( (o) -> o.getId()).max().getAsInt()))));
  }

}
