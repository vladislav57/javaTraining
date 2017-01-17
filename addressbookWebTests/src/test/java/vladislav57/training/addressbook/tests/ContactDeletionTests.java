package vladislav57.training.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by vlad on 25.12.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    if(app.getContactHelper().contactListEmpty())
      app.getContactHelper().createNewContact();
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().acceptContactDeletion();
    app.getNavigationHelper().gotoHomePage();
  }

}
