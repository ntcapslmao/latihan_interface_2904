public class Farmer extends User {
    private String farmName;

    Farmer(String name, int xCoordinate, int yCoordinate, String farmName) {
        super(name, xCoordinate, yCoordinate);
        this.farmName = farmName;
    }

    @Override
    public String getRole() {
        return "farmer";
    }

    public String getFarmName() {
        return farmName;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + super.getName());
        System.out.println("Role: " + getRole());
        System.out.println("Farm Name: " + farmName);
    }
}
