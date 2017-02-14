package vladislav57.training.addressbook.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "group_list")
public class Group {

  @Id
  @Column(name = "group_id")
  private int id = Integer.MAX_VALUE;

  @Column(name = "group_name")
  private String name = null;

  @Column(name = "group_header")
  @Type(type = "text")
  private String header = null;

  @Column(name = "group_footer")
  @Type(type = "text")
  private String footer = null;

  @Override
  public String toString() {
    return "Group{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", header='" + header + '\'' +
            ", footer='" + footer + '\'' +
            '}';
  }

  public Group(String name, String header, String footer) {
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public Group(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public Group() {}

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  public int getId() {
    return id;
  }

  public Group withId(int id) {
    this.id = id;
    return this;
  }

  public Group withName(String name) {
    this.name = name;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Group group = (Group) o;

    if (id != group.id) return false;
    if (name != null ? !name.equals(group.name) : group.name != null) return false;
    if (header != null ? !header.equals(group.header) : group.header != null) return false;
    return footer != null ? footer.equals(group.footer) : group.footer == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (header != null ? header.hashCode() : 0);
    result = 31 * result + (footer != null ? footer.hashCode() : 0);
    return result;
  }

}
