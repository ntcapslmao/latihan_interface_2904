import org.junit.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FarmerTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream outputPrintStream = System.out;
    private Farmer farmer;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        farmer = new Farmer("Ena Shinonome", 10, 20, "Jl. Margasatwa, No. 1");
    }

    @After
    public void setDown() {
        System.setOut(outputPrintStream);
    }

    @Test
    public void getterTest() {
        assertEquals("Ena Shinonome", farmer.getName());
        assertEquals("Jl. Margasatwa, No. 1", farmer.getFarmName());
        assertEquals("farmer", farmer.getRole());
    }

    @Test
    public void displayInfoTest() {
        farmer.displayInfo();

        String expected = "Name: Ena Shinonome" + System.lineSeparator() +
                            "Role: farmer" + System.lineSeparator() +
                            "Farm Name: Jl. Margasatwa, No. 1";

        String actual = outputStream.toString().trim();

        assertEquals(expected, actual);
    }
}