public class Order {
    private String orderId;
    private double price;
    private Farmer farmer;
    private Customer customer;
    private Payment payment;
    private double distance;
    private double totalPrice;

    public Order(String orderId, double price, Farmer farmer, Customer customer, Payment payment) {
        this.orderId = orderId;
        this.farmer = farmer;
        this.customer = customer;
        this.payment = payment;
        this.price = price;

        this.distance = calculateDistance();

        this.totalPrice = price + calculateDeliveryFee();
    }

    private double calculateDistance() {
        double deltaX = farmer.getXCoordinate() - customer.getXCoordinate();
        double deltaY = farmer.getYCoordinate() - customer.getYCoordinate();

        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    private double calculateDeliveryFee() {
        double ratePerUnit = 2500;
        return this.distance * ratePerUnit;
    }

    public void processOrder() {
        System.out.println("Pesanan Diproses: " + orderId);
        System.out.println("Jarak Pengiriman: " + String.format("%,.2f", distance) + "km");
        System.out.println("Harga Barang: " + String.format("Rp%,.2f", price));
        System.out.println("Biaya Pengiriman: " + String.format("Rp%,.2f", calculateDeliveryFee()));
        System.out.println("Total Biaya: " + String.format("Rp%,.2f", totalPrice));

        payment.processPayment(totalPrice);
    }
}
