package vladislav57.training.addressbook.model;

public class ContactSecondaryData {
  private final String secondaryAddress;
  private final String secondaryHome;
  private final String secondaryNote;

  public ContactSecondaryData(String secondaryAddress, String secondaryHome, String secondaryNote) {
    this.secondaryAddress = secondaryAddress;
    this.secondaryHome = secondaryHome;
    this.secondaryNote = secondaryNote;
  }

  public String getSecondaryAddress() {
    return secondaryAddress;
  }

  public String getSecondaryHome() {
    return secondaryHome;
  }

  public String getSecondaryNote() {
    return secondaryNote;
  }
}
