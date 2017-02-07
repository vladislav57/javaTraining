package vladislav57.training.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Contact;
import vladislav57.training.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.xml"));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xStream = new XStream();
    xStream.processAnnotations(Contact.class);
    List<Contact> contacts = (List<Contact>) xStream.fromXML(xml);
    return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "validContacts")
  public void testContactCreation(Contact contact) {

    app.goTo().homePage();
    Contacts before = app.contact().getAll();
    app.contact().create(contact);
    app.goTo().homePage();
    Contacts after = app.contact().getAll();

    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt( (o) -> o.getId()).max().getAsInt()))));
  }

}
