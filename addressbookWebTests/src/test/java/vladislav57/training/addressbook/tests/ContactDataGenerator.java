package vladislav57.training.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Contact;
import vladislav57.training.addressbook.model.Group;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 06.02.2017.
 */
public class ContactDataGenerator {

  private List<Contact> generateContacts(int count) {
    List<Contact> list = new ArrayList<Contact>();
    for(int i = 0; i < count; i++ ) {
      list.add(new Contact().withFirstName("firstName" + i).withLastName("lastName" + i));
    }
    return list;
  }

  private void saveContactsAsXml(List<Contact> contacts, File file) throws IOException {
    XStream xStream = new XStream();
    Writer writer = new FileWriter(file);
    writer.write(xStream.toXML(contacts));
    writer.close();
  }

  @Test
  public void testDataFileGeneration() throws IOException {
    File file = new File("src/test/resources/contacts.xml");
    saveContactsAsXml(generateContacts(3), file);
  }
}
