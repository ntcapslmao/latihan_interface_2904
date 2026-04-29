import org.junit.*;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DepositTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream outputPrintStream = System.out;
    private Deposit deposit;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void setDown() {
        System.setOut(outputPrintStream);
    }

    @Before
    public void constructorTest() {
        deposit = new Deposit(15000);
    }

    @Test
    public void processPaymentBerhasilTest() {
        deposit.processPayment(10000);

        String expected = "Pembayaran berhasil! Sisa saldo: Rp5,000.00";
        String actual = outputStream.toString().trim();

        assertEquals(expected, actual);
    }

    @Test
    public void processPaymentGagalTest() {
        deposit.processPayment(20000);

        String expected = "Pembayaran gagal. Saldo tidak cukup.";
        String actual = outputStream.toString().trim();

        assertEquals(expected, actual);
    }

    @Test
    public void topUpBerhasilTest() throws Exception {
        deposit.topUp(15000);

        assertEquals(30000, deposit.getBalance(), 0.01);

        String expected = "Berhasil menambahkan saldo sebesar: Rp15,000.00 | Saldo Terkini: Rp30,000.00";
        String actual = outputStream.toString().trim();

        assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void topUpGagalNolRupiahTest() throws Exception {
        deposit.topUp(0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void topUpGagalNegativeTest() throws Exception {
        deposit.topUp(-1);
    }
}
