import org.junit.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OrderTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream outputPrintStream = System.out;
    private Farmer farmer;
    private Customer customer;
    private Payment payment;
    private Order order;
    private FeeCalculator feeCalculator;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        farmer = new Farmer("Mizuki Akiyama", 0, 0, "Pondok Labu");
        customer = new Customer("Ena Shinonome", 3, 4, "Jl. Margasatwa, No. 1");
        payment = new COD();
        feeCalculator = new StandardCalculator();
        order = new Order("P001", 65000, farmer, customer, payment, feeCalculator);
    }

    @After
    public void setDown() {
        System.setOut(outputPrintStream);
    }

    @Test
    public void constructorTest() {
        new Order("P001", 65000, farmer, customer, payment, feeCalculator);
    }

    @Test
    public void processOrderTest() {
        order.processOrder();
        
        String expected = "Pesanan Diproses: P001" + System.lineSeparator() +
                        "Jarak Pengiriman: " + String.format("%,.2f", 5.0) + "km" + System.lineSeparator() +
                        "Harga Barang: " + String.format("Rp%,.2f", 65000.0) + System.lineSeparator() +
                        "Biaya Pengiriman: " + String.format("Rp%,.2f", 12500.0) + System.lineSeparator() +
                        "Total Biaya: " + String.format("Rp%,.2f", 77500.0) + System.lineSeparator() +
                        "Pembayaran dengan COD diproses dengan nominal: " + String.format("Rp%,.2f", 77500.0);
        
        String actual = outputStream.toString().trim();

        assertEquals(expected, actual);
    }
}
