package vladislav57.training.addressbook.model;

public class Contact {

  private int id = Integer.MAX_VALUE;
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

  @Override
  public String toString() {
    return "Contact{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", middleName='" + middleName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Contact contact = (Contact) o;

    if (id != contact.id) return false;
    if (firstName != null ? !firstName.equals(contact.firstName) : contact.firstName != null) return false;
    return lastName != null ? lastName.equals(contact.lastName) : contact.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }
}
