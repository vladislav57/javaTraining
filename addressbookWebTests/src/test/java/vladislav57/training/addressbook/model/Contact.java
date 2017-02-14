package vladislav57.training.addressbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addressbook")
public class Contact {

  @Id
  private int id = Integer.MAX_VALUE;

  @Column(name = "firstname")
  private String firstName = null;

  @Column(name = "middlename")
  private String middleName = null;

  @Column(name = "lastname")
  private String lastName = null;

  @Column(name = "nickname")
  private String nickname = null;

  @Column(name = "title")
  private String title = null;

  @Column(name = "home")
  private String homePhone = null;

  @Column(name = "work")
  private String workPhone = null;

  @Column(name = "mobile")
  private String mobilePhone = null;


  private String allPhones = null;

  @Column(name = "address")
  private String address = null;


  private String allEmail = null;

  @Column(name = "email")
  private String mail1 = null;

  @Column(name = "email2")
  private String mail2 = null;

  @Column(name = "email3")
  private String mail3 = null;

  public Contact() {}

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

  public String getHomePhone() {
    return homePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getAddress() {
    return address;
  }

  public String getAllEmail() {
    return allEmail;
  }

  public String getEmail1() {
    return mail1;
  }

  public String getEmail2() {
    return mail2;
  }

  public String getEmail3() {
    return mail3;
  }

  public String getAllPhones() {
    return allPhones;
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

  public Contact withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public Contact withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public Contact withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public Contact withPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public Contact withAddress(String address) {
    this.address = address;
    return this;
  }

  public Contact withEmails(String allEmail) {
    this.allEmail = allEmail;
    return this;
  }

  public Contact withEmail1(String mail1) {
    this.mail1 = mail1;
    return this;
  }

  public Contact withEmail2(String mail2) {
    this.mail2 = mail2;
    return this;
  }

  public Contact withEmail3(String mail3) {
    this.mail3 = mail3;
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
