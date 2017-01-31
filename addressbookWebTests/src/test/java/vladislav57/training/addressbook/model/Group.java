package vladislav57.training.addressbook.model;

public class Group {
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Group group = (Group) o;

    return name != null ? name.equals(group.name) : group.name == null;
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }

  private int id = Integer.MAX_VALUE;
  private String name = null;
  private String header = null;
  private String footer = null;

  public Group(String name, String header, String footer) {
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public Group(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public Group() {
  }

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

}
