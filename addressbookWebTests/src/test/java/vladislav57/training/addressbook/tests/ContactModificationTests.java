package vladislav57.training.addressbook.tests;

import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.ContactNameData;

/**
 * Created by vlad on 04.01.2017.
 */
public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if(app.getContactHelper().contactListEmpty())
      app.getContactHelper().createNewContact(new ContactNameData("firstName", "middleName", "lastName", "nick", "title"));
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().modify(1, new ContactNameData("firstName", "middleName", "lastName", "nickname", "title"));
    app.getNavigationHelper().gotoHomePage();
  }
}
