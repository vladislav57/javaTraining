package vladislav57.training.addressbook.tests;

import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.*;

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
    app.getContactHelper().selectContact(1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactNames(new ContactNameData("firstName", "middleName", "lastName", "nickname", "title"));
    app.getContactHelper().fillContactEmployerData(new ContactEmployerData("company", "workPhone"));
    app.getContactHelper().fillContactAddressData(new ContactAddressData("address", "homePhome"));
    app.getContactHelper().fillContactContactsData(new ContactContactsData("mobilePhone", "fax", "e-mail", "e-mail2", "e-mail3", "homepage"));
    app.getContactHelper().fillContactBirthDate("1990");
    app.getContactHelper().fillContactAnniversaryDate("2010");
    app.getContactHelper().fillContactSecondaryData(new ContactSecondaryData("address2", "phone2", "notes"));
    app.getContactHelper().submitContactEditData();
    app.getNavigationHelper().gotoHomePage();
  }
}
