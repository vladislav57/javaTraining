package vladislav57.training.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void ContactCreationTests() {
        initContactCreation();
        fillContactNames(new ContactNameData("firstName", "middleName", "lastName", "nickname", "title"));
        fillContactEmployerData(new ContactEmployerData("company", "workPhone"));
        fillContactAddressData(new ContactAddressData("address", "homePhome"));
        fillContactContactsData(new ContactContactsData("mobilePhone", "fax", "e-mail", "e-mail2", "e-mail3", "homepage"));
        fillContactBirthDate("1990");
        fillContactAnniversaryDate("2010");
        fillContactSecondaryData(new ContactSecondaryData("address2", "phone2", "notes"));
        submitContactData();
        gotoHomePage();
    }

}
