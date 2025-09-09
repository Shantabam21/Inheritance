import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PersonTest {
    Person p1, p2, p3, p4, p5;


    @BeforeEach
    void setUp() {
        p1 = new Person("000001", "Bilbo", "Baggins", "Esq.", 2000);
        p2= new Person("000002", "Frodo", "Baggins", "Esq.", 1950);
        p3 = new Person("000003", "Samwise", "Gamgee", "Esq.", 1960);
        p4 = new Person("000004", "Peregrin", "Took", "Esq.", 1950);
        p5 = new Person("000005", "Meridoc", "Brandybuck", "Esq.", 1970);
    }

    @Test
    void toCVS() {
        String expected = "000001, Bilbo, Baggins, Esq., 2000";
        String actual = p1.toCVS();
        assertEquals(expected, actual);
    }

    @Test
    void toJSON() {
        String expected = "{" +
                "\"IDNum\":\"" + "000001" + "\"," +
                "\"firstName\":\"" + "Bilbo" + "\"," +
                "\"lastName\":\"" + "Baggins" + "\"," +
                "\"title\":\"" + "Esq." + "\"," +
                "\"YOB\":" + 2000 + "," +
                "}";
        String actual = p1.toJSON();
        assertEquals(expected, actual);
    }

    @Test
    void toXML() {
        String expected = "<Person>";
        expected += "<IDNum>" + "000001" + "</IDNum>";
        expected += "<firstName>" + "Bilbo" + "</firstName>";
        expected += "<lastName>" + "Baggins" + "</lastName>";
        expected += "<title>" + "Esq." + "</title>";
        expected += "<YOB>" + 2000 + "</YOB></Person>";
        String actual = p1.toXML();
        assertEquals(expected, actual);
    }

    @Test
    void testToString() {
        String expected = "000001, Bilbo, Baggins, Esq.," + " " + 2000;
        String actual = p1.toCVS();
        assertEquals(expected, actual);
    }

    @Test
    void setIDNum() {
        p1.setIDNum("000001");
        assertEquals("000001", p1.getIDNum());
    }

    @Test
    void setFirstName() {
        p1.setFirstName("Askar");
        assertEquals("Askar", p1.getFirstName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Bolot");
        assertEquals("Bolot", p1.getLastName());
    }

    @Test
    void setTitle() {
        p1.setTitle("title");
        assertEquals("title", p1.getTitle());
    }

    @Test
    void setYOB() {
        p1.setYOB(2010);
        assertEquals(2010, p1.getYOB());
    }

    @Test
    void testEquals() {
        p1.setIDNum("000002");
        p1.setFirstName("Frodo");
        p1.setLastName("Baggins");
        p1.setTitle("Esq.");
        p1.setYOB(1950);
        assertEquals(true, p2.equals(p1));
    }

    @Test
    void testHashCode() {
        assertNotEquals(p1.hashCode(), p2.hashCode());
        assertEquals(p3.hashCode(), p3.hashCode());
    }

}