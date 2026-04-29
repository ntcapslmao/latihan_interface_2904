import org.junit.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CustomerTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream outputPrintStream = System.out;
    private Customer customer;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        customer = new Customer("Ena Shinonome", 10, 20, "Jl. Margasatwa, No. 1");
    }

    @After
    public void setDown() {
        System.setOut(outputPrintStream);
    }

    @Test
    public void getterTest() {
        assertEquals("Ena Shinonome", customer.getName());
        assertEquals("Jl. Margasatwa, No. 1", customer.getAddressName());
        assertEquals("customer", customer.getRole());
    }

    @Test
    public void displayInfoTest() {
        customer.displayInfo();

        String expected = "Name: Ena Shinonome" + System.lineSeparator() +
                            "Role: customer" + System.lineSeparator() +
                            "Address: Jl. Margasatwa, No. 1";

        String actual = outputStream.toString().trim();

        assertEquals(expected, actual);
    }
}