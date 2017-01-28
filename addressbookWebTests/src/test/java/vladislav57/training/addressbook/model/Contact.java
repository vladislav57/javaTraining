package vladislav57.training.addressbook.model;

public class Contact {
  private int id = 0;
  private String firstName = null;
  private String middleName = null;
  private String lastName = null;
  private String nickname = null;
  private String title = null;

  public Contact(String firstName, String middleName, String lastName, String nickname, String title) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.title = title;
  }

  public Contact(int id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Contact() {
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public Contact withId(int id) {
    this.id = id;
    return this;
  }

  public Contact withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public Contact withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

}
