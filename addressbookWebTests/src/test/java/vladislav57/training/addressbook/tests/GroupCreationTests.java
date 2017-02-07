package vladislav57.training.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Group;
import vladislav57.training.addressbook.model.Groups;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/groups.xml"));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xStream = new XStream();
    xStream.processAnnotations(Group.class);
    List<Group> groups = (List<Group>) xStream.fromXML(xml);
    return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(Group group) {

    app.goTo().groupsPage();
    Groups before = app.group().getAll();
    app.group().create(group);
    app.goTo().groupsPage();
    Groups after = app.group().getAll();

    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt( (o) -> o.getId()).max().getAsInt()))));
  }

}
