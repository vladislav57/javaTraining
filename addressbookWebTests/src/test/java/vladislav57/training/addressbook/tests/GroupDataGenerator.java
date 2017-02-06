package vladislav57.training.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.Test;
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
public class GroupDataGenerator {
  private List<Group> generateGroups(int count) {
    List<Group> list = new ArrayList<Group>();
    for(int i = 0; i < count; i++ ) {
      list.add(new Group().withName("groupName" + i));
    }
    return list;
  }
  private void saveGroupAsXml(List<Group> groups, File file) throws IOException {
    XStream xStream = new XStream();
    Writer writer = new FileWriter(file);
    writer.write(xStream.toXML(groups));
    writer.close();
  }

  @Test
  public void testDataFileGeneration() throws IOException {
    File file = new File("src/test/resources/groups.xml");
    saveGroupAsXml(generateGroups(3), file);
  }
}
