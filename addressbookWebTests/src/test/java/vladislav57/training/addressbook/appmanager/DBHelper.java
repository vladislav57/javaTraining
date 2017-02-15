package vladislav57.training.addressbook.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import vladislav57.training.addressbook.model.Contact;
import vladislav57.training.addressbook.model.Contacts;
import vladislav57.training.addressbook.model.Group;
import vladislav57.training.addressbook.model.Groups;

import java.util.List;

/**
 * Created by vlad on 13.02.2017.
 */
public class DBHelper {
  private SessionFactory sessionFactory;

  protected void setUp() throws Exception {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    try {
      sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }
    catch (Exception e) {
      e.printStackTrace();
      StandardServiceRegistryBuilder.destroy( registry );
    }
  }

  public Groups getGroups() {

    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Group> list = session.createQuery( "from Group" ).list();
    Groups groups = new Groups(list);
    session.getTransaction().commit();
    session.close();
    return groups;
  }

  public Contacts getContacts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Contact> list = session.createQuery( "from Contact where deprecated = '0000-00-00'" ).list();
    Contacts contacts = new Contacts(list);
    session.getTransaction().commit();
    session.close();
    return contacts;
  }
}
