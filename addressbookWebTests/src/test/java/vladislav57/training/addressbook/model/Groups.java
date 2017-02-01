package vladislav57.training.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vlad on 01.02.2017.
 */
public class Groups extends ForwardingSet {
  public Set<Group> groups = new HashSet<>();

  @Override
  protected Set delegate() {
    return null;
  }


}
