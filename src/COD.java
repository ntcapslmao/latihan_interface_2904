public class COD implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.printf("Pembayaran dengan COD diproses dengan nominal: Rp%,.2f\n", amount);
    }
}
