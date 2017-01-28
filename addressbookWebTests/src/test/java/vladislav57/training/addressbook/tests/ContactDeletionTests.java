package vladislav57.training.addressbook.tests;

import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Contact;

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
    app.contact().delete(1);
    app.goTo().homePage();
  }

}
