package vladislav57.training.addressbook;

public class ContactContactsData {
  private final String mobilePhone;
  private final String fax;
  private final String email;
  private final String email2;
  private final String email3;
  private final String homepage;

  public ContactContactsData(String mobilePhone, String fax, String email, String email2, String email3, String homepage) {
    this.mobilePhone = mobilePhone;
    this.fax = fax;
    this.email = email;
    this.email2 = email2;
    this.email3 = email3;
    this.homepage = homepage;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getHomepage() {
    return homepage;
  }
}
