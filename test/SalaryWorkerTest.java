import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SalaryWorkerTest {
    SalaryWorker s1, s2;

    @BeforeEach
    void setUp() {
        s1 = new SalaryWorker("000001", "Askar", "Bolot", "Esq.", 2007, 48.08, 100000);
        s2 = new SalaryWorker("000002", "Aidar", "Bolot","Esq.", 2000, 57.69, 120000);
    }

    @Test
    void calculateWeeklyPay() {
        double expected = s1.getAnnualSalary() / 52;
        assertEquals(expected, s1.calculateWeeklyPay(50.0));
    }

    @Test
    void displayWeeklyPay() {
        // Capture System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Run the method with overtime
        s1.displayWeeklyPay(45);

        // Reset System.out
        System.setOut(originalOut);

        String output = outContent.toString();
        System.out.println(output);
        // Check values
        assertTrue(output.contains("Weekly Pay (a fraction of the yearly salary)"));
        assertTrue(output.contains("$1923.08"));


    }

    @Test
    void toCVS() {
        String expected = "000001, Askar, Bolot, Esq., 2007, 48.08, 100000.0";
        String actual = s1.toCVS();
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
                "\"hourlyPayRate\":\"" + 48.08 + "\"," +
                "\"annualSalary\":\"" + 100000.0 + "\"" +
                "}";
        String actual = s1.toJSON();
        assertEquals(expected, actual);
    }

    @Test
    void toXML() {
        String expected = "<SalaryWorker>";
        expected += "<IDNum>" + "000001" + "</IDNum>";
        expected += "<firstName>" + "Askar" + "</firstName>";
        expected += "<lastName>" + "Bolot" + "</lastName>";
        expected += "<title>" + "Esq." + "</title>";
        expected += "<YOB>" + 2007 + "</YOB>";
        expected += "<hourlyPayRate>" + "48.08" + "</hourlyPayRate>";
        expected += "<annualSalary>" + 100000.0 + "</annualSalary>" + "</SalaryWorker>";
        String actual = s1.toXML();
        assertEquals(expected, actual);
    }

    @Test
    void getAnnualSalary() {
        assertEquals(100000, s1.getAnnualSalary());
    }

    @Test
    void setAnnualSalary() {
        s1.setAnnualSalary(80000);
        assertEquals(80000, s1.getAnnualSalary());
    }

    @Test
    void testEquals() {
        s2.setIDNum("000001");
        s2.setFirstName("Askar");
        s2.setLastName("Bolot");
        s2.setTitle("Esq.");
        s2.setYOB(2007);
        s2.setHourlyPayRate(48.08);
        s2.setAnnualSalary(100000);
        assertEquals(s2, s1);
    }

    @Test
    void testHashCode() {
        assertNotEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    void testToString() {
        String expected = "000001, Askar, Bolot, Esq., 2007, 48.08, 100000.0";
        String actual = s1.toString();
        assertEquals(expected, actual);
    }
}