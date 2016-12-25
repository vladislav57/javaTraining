package vladislav57.training.addressbook.tests;

import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.*;

public class ContactCreationTests extends TestBase {

    @Test
    public void ContactCreationTests() {
        app.initContactCreation();
        app.fillContactNames(new ContactNameData("firstName", "middleName", "lastName", "nickname", "title"));
        app.fillContactEmployerData(new ContactEmployerData("company", "workPhone"));
        app.fillContactAddressData(new ContactAddressData("address", "homePhome"));
        app.fillContactContactsData(new ContactContactsData("mobilePhone", "fax", "e-mail", "e-mail2", "e-mail3", "homepage"));
        app.fillContactBirthDate("1990");
        app.fillContactAnniversaryDate("2010");
        app.fillContactSecondaryData(new ContactSecondaryData("address2", "phone2", "notes"));
        app.submitContactData();
        app.gotoHomePage();
    }

}
