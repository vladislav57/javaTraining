package vladislav57.training.addressbook.tests;

import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Contact;

/**
 * Created by vlad on 04.01.2017.
 */
public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    app.goTo().homePage();
    if(app.contact().listIsEmpty())
      app.contact().create(new Contact().withFirstName("firstName").withLastName("lastName"));
    app.goTo().homePage();
    app.contact().modify(1, new Contact().withFirstName("firstName").withLastName("lastName"));
    app.goTo().homePage();
  }
}
