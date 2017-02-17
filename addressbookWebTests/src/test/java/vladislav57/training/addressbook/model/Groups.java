package vladislav57.training.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.List;
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

  public Groups(List<Group> list) {
    this.delegate = new HashSet<Group>(list);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    Groups groups = (Groups) o;

    return delegate != null ? delegate.equals(groups.delegate) : groups.delegate == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (delegate != null ? delegate.hashCode() : 0);
    return result;
  }

  public Groups(Set<Group> groups) {
    this.delegate = new HashSet<Group>(groups);
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
