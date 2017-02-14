package vladislav57.training.addressbook.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vladislav57.training.addressbook.model.Group;

import java.util.List;

/**
 * Created by vlad on 11.02.2017.
 */
public class HbConnectionTest {

  private SessionFactory sessionFactory;

  @BeforeClass
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

  @Test
  public void testHibernateConnection() {

    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Group> result = session.createQuery( "from Group" ).list();
    for ( Group group : result ) {
      System.out.println(group);
    }
    session.getTransaction().commit();
    session.close();

  }

}
