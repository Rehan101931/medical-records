import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PatientIDTest {

    @Test
    void testToString() {
        Name nm = new Name("Grease", "Lyons");
        Date dob = new Date(0);

        PatientID id = new PatientID(nm, dob);

        assertEquals("name: grease lyons dob: " + dob.toString(), id.toString());
        System.out.println(id);
    }

    @Test
    void getName() {
        Name nm = new Name("Bob", "Cheddar");
        Date dob = new Date(0);

        PatientID id = new PatientID(nm, dob);

        assertEquals(nm, id.getName());
    }

    @Test
    void getDateOfBirth() {
        Name nm = new Name("Zarch", "Gobligook");
        Date dob = new Date(20);

        PatientID id = new PatientID(nm, dob);

        assertEquals(dob, id.getDateOfBirth());
    }

    @Test
    void match() {
        Name nm1 = new Name("Asta", "Staria");
        Name nm2 = new Name("Asta", "Staria");

        Date dob1 = new Date(30);
        Date dob2 = new Date(30);

        PatientID id1 = new PatientID(nm1, dob1);
        PatientID id2 = new PatientID(nm2, dob2);

        assertTrue(id1.match(id2));
    }

    @Test
    void isLessThan() {
        Name nm1 = new Name("Jimbob", "Grenich");
        Name nm2 = new Name("Dahistorius", "Lamystorius");

        Date dob1 = new Date(0);
        Date dob2 = new Date(1000);

        PatientID id1 = new PatientID(nm1, dob1);
        PatientID id2 = new PatientID(nm2, dob2);

        assertFalse(id1.isLessThan(id2));
    }
}