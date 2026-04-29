public class Deposit implements Payment {
    private double balance;

    public Deposit(double initialBal) {
        this.balance = initialBal;
    }

    @Override
    public void processPayment(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.printf("Pembayaran berhasil! Sisa saldo: Rp%,.2f\n", balance);
        }
        else {
            System.out.println("Pembayaran gagal. Saldo tidak cukup.");
        }
    }

    public void topUp(double amount) throws Exception {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Berhasil menambahkan saldo sebesar: Rp%,.2f | Saldo Terkini: Rp%,.2f\n", amount, balance);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public double getBalance() {
        return balance;
    }
}
