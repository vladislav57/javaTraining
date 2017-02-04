package vladislav57.training.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vlad on 04.02.2017.
 */
public class Contacts extends ForwardingSet<Contact> {
  private Set<Contact> delegate;

  public Contacts(Set<Contact> delegate) {
    this.delegate = new HashSet<Contact>(delegate);
  }

  public Contacts() {
    this.delegate = new HashSet<Contact>();
  }

  @Override
  protected Set<Contact> delegate() {
    return delegate;
  }

  public Contacts withAdded(Contact contact) {
    Contacts contacts = new Contacts(this.delegate);
    contacts.add(contact);
    return contacts;
  }

  public Contacts without(Contact contact) {
    Contacts contacts = new Contacts(this.delegate);
    contacts.remove(contact);
    return contacts;
  }
}
