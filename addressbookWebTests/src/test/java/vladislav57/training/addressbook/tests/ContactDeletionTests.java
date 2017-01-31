package vladislav57.training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Contact;

import java.util.Comparator;
import java.util.List;

/**
 * Created by vlad on 25.12.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    Contact contact = new Contact().withFirstName("firstName").withLastName("lastName");
    int index = 1;

    app.goTo().homePage();
    if(app.contact().listIsEmpty())
      app.contact().create(contact);
    app.goTo().homePage();
    List<Contact> before = app.contact().getAll();
    app.contact().delete(index);
    app.goTo().homePage();
    List<Contact> after = app.contact().getAll();
    Assert.assertEquals(before.size(), after.size() + 1);

    before.remove(index);
    Comparator<? super Contact> ById = (Comparator<Contact>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    before.sort(ById);
    after.sort(ById);
    Assert.assertEquals(before, after);
  }

}
