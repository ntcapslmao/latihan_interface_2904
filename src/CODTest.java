import org.junit.*;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CODTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream outputPrintStream = System.out;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void setDown() {
        System.setOut(outputPrintStream);
    }

    @Test
    public void constructorTest() {
        new COD();
    }

    @Test
    public void processPaymentTest() {
        COD myPayment = new COD();
        myPayment.processPayment(10000);

        String expected = "Pembayaran dengan COD diproses dengan nominal: Rp10,000.00";
        String actual = outputStream.toString().trim();

        assertEquals(expected, actual);
    }
}
