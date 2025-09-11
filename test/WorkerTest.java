import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
    Worker worker;
    Worker w;

    @BeforeEach
    void setUp() {
        w = new Worker("123", "John", "Doe", "Mr.", 1980, 20.0);

        worker = new Worker("000001", "Askar", "Bolot", "Esq.", 2007, 20.0);
    }

    @Test
    void getHourlyPayRate() {
        assertEquals(worker.getHourlyPayRate(), 20.0);
    }

    @Test
    void setHourlyPayRate() {
        worker.setHourlyPayRate(10.0);
        assertEquals(worker.getHourlyPayRate(), 10.0);
    }

    @Test
    void calculateWeeklyPay() {

        assertEquals(worker.calculateWeeklyPay(50.0), 1100.0);
    }

    @Test
    void displayWeeklyPay() {
        // Capture System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Run the method with overtime
        w.displayWeeklyPay(45);

        // Reset System.out
        System.setOut(originalOut);

        String output = outContent.toString();
        System.out.println(output);
        // Check values
        assertTrue(output.contains("Regular Pay hours"));
        assertTrue(output.contains("40.0"));  // Regular hours
        assertTrue(output.contains("800.0")); // Regular pay
        assertTrue(output.contains("5.0"));   // Overtime hours
        assertTrue(output.contains("150.0")); // Overtime pay (5 * 30)

    }

    @Test
    void toCVS() {
        String expected = "000001, Askar, Bolot, Esq., 2007, 20.0";
        String actual = worker.toCVS();
        assertEquals(expected, actual);
    }

    @Test
    void toJSON() {
        String expected = "{" +
                "\"IDNum\":\"" + "000001" + "\"," +
                "\"firstName\":\"" + "Askar" + "\"," +
                "\"lastName\":\"" + "Bolot" + "\"," +
                "\"title\":\"" + "Esq." + "\"," +
                "\"YOB\":\"" + 2007 + "\"," +
                "\"hourlyPayRate\":\"" + worker.getHourlyPayRate() + "\"" +
                "}";
        String actual = worker.toJSON();
        assertEquals(expected, actual);
    }

    @Test
    void toXML() {
        String expected = "<Worker>";
        expected += "<IDNum>" + "000001" + "</IDNum>";
        expected += "<firstName>" + "Askar" + "</firstName>";
        expected += "<lastName>" + "Bolot" + "</lastName>";
        expected += "<title>" + "Esq." + "</title>";
        expected += "<YOB>" + 2007 + "</YOB>";
        expected += "<hourlyPayRate>" + worker.getHourlyPayRate() + "</hourlyPayRate>" + "</Worker>";
        String actual = worker.toXML();
        assertEquals(expected, actual);
    }

    @Test
    void testToString() {
        String expected = "000001, Askar, Bolot, Esq., "  + 2007 + ", " + 20.0;
        String actual = worker.toCVS();
        assertEquals(expected, actual);
    }

    @Test
    void testEquals() {
        w.setIDNum("000001");
        w.setFirstName("Askar");
        w.setLastName("Bolot");
        w.setTitle("Esq.");
        w.setYOB(2007);
        assertEquals(true, worker.equals(w));
    }

    @Test
    void testHashCode() {
        assertNotEquals(w.hashCode(), worker.hashCode());
    }
}