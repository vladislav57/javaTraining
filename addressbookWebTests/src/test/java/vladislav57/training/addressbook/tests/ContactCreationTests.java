package vladislav57.training.addressbook.tests;

import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.*;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactNames(new Contact("firstName", "middleName", "lastName", "nickname", "title"));
        app.getContactHelper().fillContactBirthDate("1990");
        app.getContactHelper().fillContactAnniversaryDate("2010");
        app.getContactHelper().submitContactCreateData();
        app.getNavigationHelper().gotoHomePage();
    }

}
