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
        w = new Worker("123", "John", "Doe", "Mr.", 30, 20.0);

        worker = new Worker("000001", "Askar", "Bolot", "Esq.", 18, 20.0);
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

        w.displayWeeklyPay(40);

        // Reset System.out
        System.setOut(originalOut);

        String output = outContent.toString();
        assertTrue(output.contains("Regular Pay hours: 40.0"));
        assertTrue(output.contains("Regular Pay: 800.0"));
        assertTrue(output.contains("Overtime Pay: 0"));
        assertTrue(output.contains("Overtime Pay: 0"));
        assertTrue(output.contains("Combined Pay: 800.0"));
    }

    @Test
    void toCVS() {
    }

    @Test
    void toJSON() {
    }

    @Test
    void toXML() {
    }

    @Test
    void testToString() {
        String expected = "000001, Bilbo, Baggins, Esq.," + " " + 2000;
        String actual = worker.toCVS();
        assertEquals(expected, actual);
    }
}