package vladislav57.training.addressbook.model;

public class ContactAddressData {
  private final String address;
  private final String homePhone;

  public ContactAddressData(String address, String homePhone) {
    this.address = address;
    this.homePhone = homePhone;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }
}
