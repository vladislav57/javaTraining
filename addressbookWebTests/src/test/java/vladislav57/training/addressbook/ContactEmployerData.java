package vladislav57.training.addressbook;

public class ContactEmployerData {
  private final String company;
  private final String workPhone;

  public ContactEmployerData(String company, String workPhone) {
    this.company = company;
    this.workPhone = workPhone;
  }

  public String getCompany() {
    return company;
  }

  public String getWorkPhone() {
    return workPhone;
  }
}
