public class Costumer extends User {
    private String addressName;

    Costumer(String name, int xCoordinate, int yCoordinate, String addressName) {
        super(name, xCoordinate, yCoordinate);
        this.addressName = addressName;
    }

    @Override
    public String getRole() {
        return "costumer";
    }

    public String getAddressName() {
        return addressName;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + super.getName());
        System.out.println("Role: " + getRole());
        System.out.println("Address: " + addressName);
    }
}
