package vladislav57.training.addressbook.tests;

import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.ContactData;

/**
 * Created by vlad on 25.12.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    if(app.getContactHelper().contactListEmpty())
      app.getContactHelper().createNewContact(new ContactData("firstName", "middleName", "lastName", "nick", "title"));
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact(1);
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().acceptContactDeletion();
    app.getNavigationHelper().gotoHomePage();
  }

}
