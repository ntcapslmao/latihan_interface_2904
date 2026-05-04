public class Order {
    private String orderId;
    private double price;
    private Farmer seller;
    private Customer buyer;
    private Payment payment;
    private double distance;
    private double totalPrice;
    private FeeCalculator feeCalculator;

    public Order(String orderId, double price, Farmer seller, Customer buyer, Payment payment, FeeCalculator feeCalculator) {
        this.orderId = orderId;
        this.seller = seller;
        this.buyer = buyer;
        this.payment = payment;
        this.feeCalculator = feeCalculator;
        this.price = price;

        this.distance = feeCalculator.calculateDistance(seller, buyer);
        this.totalPrice = price + feeCalculator.calculateDeliveryFee(this.distance);
    }

    public void processOrder() {
        System.out.println("Pesanan Diproses: " + orderId);
        System.out.println("Jarak Pengiriman: " + String.format("%,.2f", feeCalculator.calculateDistance(seller, buyer)) + "km");
        System.out.println("Harga Barang: " + String.format("Rp%,.2f", price));
        System.out.println("Biaya Pengiriman: " + String.format("Rp%,.2f", feeCalculator.calculateDeliveryFee(this.distance)));
        System.out.println("Total Biaya: " + String.format("Rp%,.2f", totalPrice));

        payment.processPayment(totalPrice);
    }
}
