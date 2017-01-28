package vladislav57.training.addressbook.tests;

import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.*;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.contact().create(new Contact().withFirstName("firstName").withLastName("lastName"));
        app.goTo().homePage();
    }

}
