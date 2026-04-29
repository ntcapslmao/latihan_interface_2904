public class Customer extends User {
    private String addressName;

    Customer(String name, int xCoordinate, int yCoordinate, String addressName) {
        super(name, xCoordinate, yCoordinate);
        this.addressName = addressName;
    }

    @Override
    public String getRole() {
        return "customer";
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
