public abstract class User {
    private String name;
    private int xCoordinate;
    private int yCoordinate;

    public User(String name, int xCoordinate, int yCoordinate) {
        this.name = name;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public abstract String getRole();
    public abstract void displayInfo();

    public String getName() { return name; }

    public int getXCoordinate() { return xCoordinate; }

    public int getYCoordinate() { return yCoordinate; }
}
