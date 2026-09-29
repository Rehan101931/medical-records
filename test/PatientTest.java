import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    void getIdentity() {
        Name nm = new Name("Joe", "Biden");
        Date dob = new Date(902);

        PatientID id = new PatientID(nm, dob);
        Patient patient = new Patient(id);

        assertEquals(id, patient.getIdentity());
    }

    @Test
    void testToString() {
        Name nm = new Name("Godzilla", "Ohnoooooo");
        Date dob = new Date(62);

        PatientID id = new PatientID(nm, dob);
        Patient patient = new Patient(id);

        assertEquals("identity: name: godzilla ohnoooooo dob: " + dob.toString(),
                patient.toString());
    }
}