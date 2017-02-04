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
 * Created by vlad on 25.12.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.goTo().homePage();
    if(app.contact().listIsEmpty())
      app.contact().create(new Contact().withFirstName("firstName").withLastName("lastName"));
    app.goTo().homePage();
    Contacts before = app.contact().getAll();
    Contact delete = before.iterator().next();
    app.contact().delete(delete);
    app.goTo().homePage();
    Contacts after = app.contact().getAll();

    assertThat(after.size(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.without(delete)));
  }

}
