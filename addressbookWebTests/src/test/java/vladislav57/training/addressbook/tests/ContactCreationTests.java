package vladislav57.training.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.*;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    Contact contact = new Contact().withFirstName("firstName").withLastName("lastName");

    app.goTo().homePage();
    List<Contact> before = app.contact().getAll();
    app.contact().create(contact);
    app.goTo().homePage();
    List<Contact> after = app.contact().getAll();
    Assert.assertEquals(before.size() + 1, after.size());

    before.add(contact);
    Comparator<? super Contact> ById = (Comparator<Contact>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    before.sort(ById);
    after.sort(ById);
    Assert.assertEquals(before, after);
  }

}
