package vladislav57.training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Contact;

import java.util.Comparator;
import java.util.List;

/**
 * Created by vlad on 04.01.2017.
 */
public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    Contact contact = new Contact().withFirstName("firstName").withLastName("lastName");
    int index = 1;

    app.goTo().homePage();
    if(app.contact().listIsEmpty())
      app.contact().create(contact);
    app.goTo().homePage();
    List<Contact> before = app.contact().getAll();
    app.contact().modify(index, contact);
    app.goTo().homePage();
    List<Contact> after = app.contact().getAll();
    Assert.assertEquals(before.size(), after.size());

    before.get(index).withFirstName(contact.getFirstName()).withLastName(contact.getLastName());
    Comparator<? super Contact> ById = (Comparator<Contact>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    before.sort(ById);
    after.sort(ById);
    Assert.assertEquals(before, after);
  }
}
