package vladislav57.training.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vlad on 01.02.2017.
 */
public class Groups extends ForwardingSet<Group> {
  private Set<Group> delegate;

  public Groups(Groups groups) {
    this.delegate = new HashSet<Group>(groups.delegate());
  }

  public Groups() {
    this.delegate = new HashSet<Group>();
  }

  @Override
  protected Set delegate() {
    return delegate;
  }

  public Groups withAdded(Group group) {
    Groups groups = new Groups(this);
    groups.add(group);
    return groups;
  }

  public Groups without(Group group) {
    Groups groups = new Groups(this);
    groups.remove(group);
    return groups;
  }

}
