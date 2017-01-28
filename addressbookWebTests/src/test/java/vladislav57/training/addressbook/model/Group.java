package vladislav57.training.addressbook.model;

public class Group {
  private int id = 0;
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
