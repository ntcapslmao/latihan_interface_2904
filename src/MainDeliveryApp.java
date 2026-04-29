public class MainDeliveryApp {
    public static void main(String[] args) {
        System.out.println("=== Inisialisasi Pengguna ===");
        
        Farmer farmer1 = new Farmer("Pak Somad", 2, 5, "Kebun Kukusan");
        farmer1.displayInfo();
        
        System.out.println("-------------------------");
        
        Customer customer1 = new Customer("Budi", 10, 11, "Asrama Mahasiswa");
        customer1.displayInfo();


        System.out.println("\n=== Kasus 1: Pembayaran COD ===");
        Payment codPayment = new COD();
        
        Order order1 = new Order("ORD-001", 50000, farmer1, customer1, codPayment);
        order1.processOrder();

        System.out.println("\n=== Kasus 2: Pembayaran Deposit (Sukses) ===");
        Deposit depositPayment = new Deposit(150000); // Saldo awal Rp 150.000
        Order order2 = new Order("ORD-002", 75000, farmer1, customer1, depositPayment);
        order2.processOrder();

        System.out.println("\n=== Kasus 3: Pembayaran Deposit (Gagal & Top Up) ===");
        Order order3 = new Order("ORD-003", 100000, farmer1, customer1, depositPayment);
        order3.processOrder(); // Pembayaran seharusnya ditolak karena saldo kurang
        
        System.out.println("\n-- Melakukan Top Up Saldo --");
        try {
            depositPayment.topUp(100000); // Menambah saldo Rp 100.000
            System.out.println("\n-- Mencoba ulang pesanan ORD-003 --");
            order3.processOrder(); // Sekarang pembayaran akan berhasil
        } catch (Exception e) {
            System.out.println("Top up gagal: Nominal tidak valid!");
        }
    }
}