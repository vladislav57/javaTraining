package vladislav57.training.addressbook.tests;

import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.*;

public class ContactCreationTests extends TestBase {

    @Test
    public void ContactCreationTests() {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactNames(new ContactNameData("firstName", "middleName", "lastName", "nickname", "title"));
        app.getContactHelper().fillContactEmployerData(new ContactEmployerData("company", "workPhone"));
        app.getContactHelper().fillContactAddressData(new ContactAddressData("address", "homePhome"));
        app.getContactHelper().fillContactContactsData(new ContactContactsData("mobilePhone", "fax", "e-mail", "e-mail2", "e-mail3", "homepage"));
        app.getContactHelper().fillContactBirthDate("1990");
        app.getContactHelper().fillContactAnniversaryDate("2010");
        app.getContactHelper().fillContactSecondaryData(new ContactSecondaryData("address2", "phone2", "notes"));
        app.getContactHelper().submitContactData();
        app.getNavigationHelper().gotoHomePage();
    }

}
