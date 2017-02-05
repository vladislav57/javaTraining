package vladislav57.training.addressbook.tests;

import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Contact;
import vladislav57.training.addressbook.model.Contacts;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by vlad on 04.02.2017.
 */
public class ContactDataTests extends TestBase{
  @Test
  public void testContactEditForm() {
    Contact contact = new Contact().withFirstName("testData").withHomePhone("8-495-942-06-32")
            .withMobilePhone("+7(920)3072359").withWorkPhone("8 800 100 20 20")
            .withEmail1("mail1").withEmail2("mail2").withEmail3("mail3").withAddress("123098 Russia Moscow");
    Contact testContact = null;

    app.goTo().homePage();
    if(!app.contact().listIsEmpty()) {
      Contacts contacts = app.contact().getAll();
      if (contacts.stream().filter((s) -> s.getFirstName().equals("testData")).count() > 0) {
        testContact = contacts.stream().filter((s) -> s.getFirstName().equals("testData")).iterator().next();
      } else {
        testContact = contacts.iterator().next();
        app.contact().modify(testContact, contact);
        app.goTo().homePage();
      }
    } else {
      app.contact().create(contact);
      app.goTo().homePage();
      testContact = app.contact().getAll().iterator().next();
    }

    Contact infoFromEditPage = app.contact().getInfoFromEditPage(testContact);
    assertThat(testContact.getAllPhones(), equalTo(mergePhones(infoFromEditPage)));
    assertThat(testContact.getAllEmail(), equalTo(mergeEmails(infoFromEditPage)));
    assertThat(testContact.getAddress(), equalTo(infoFromEditPage.getAddress()));
  }

  private String mergeEmails(Contact contact) {
    return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  private String mergePhones(Contact contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactDataTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

}
