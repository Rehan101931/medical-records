import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PatientListTest {

    @Test
    void add() {
        PatientList list = new PatientList();
        Name n1 = new Name("King", "Kong");
        Name n2 = new Name("Killer", "Queen");
        PatientID id1 = new PatientID(n1, new Date(1381));
        PatientID id2 = new PatientID(n2, new Date(1827));
        Patient p1 = new Patient(id1);
        Patient p2 = new Patient(id2);
        assertTrue(list.add(p1));
        assertTrue(list.add(p2));
        assertSame(p1, list.find(id1));
        assertSame(p2, list.find(id2));
    }

    @Test
    void find() {
        PatientList list = new PatientList();
        Name n1 = new Name("Billy", "Banjo");
        Name n2 = new Name("John", "Smith");
        Name n3 = new Name("Sam", "Wilson");
        PatientID id1 = new PatientID(n1, new Date(1273));
        PatientID id2 = new PatientID(n2, new Date(1298));
        PatientID id3 = new PatientID(n3, new Date(1273));
        Patient p1 = new Patient(id1);
        Patient p2 = new Patient(id2);
        Patient p3 = new Patient(id3);
        list.add(p3);
        list.add(p1);
        list.add(p2);
        assertSame(p1, list.find(id1));
        assertSame(p2, list.find(id2));
        assertSame(p3, list.find(id3));
    }

    @Test
    void merge() {
        PatientList list1 = new PatientList();
        PatientList list2 = new PatientList();
        Name n1 = new Name("Crazy", "Diamond");
        Name n2 = new Name("God", "Zilla");
        Name n3 = new Name("Psyduck", "Gengar");
        Name n4 = new Name("Michael", "Myers");
        PatientID id1 = new PatientID(n1, new Date(1345));
        PatientID id2 = new PatientID(n2, new Date(1918));
        PatientID id3 = new PatientID(n3, new Date(2834));
        PatientID id4 = new PatientID(n4, new Date(3251));
        Patient p1 = new Patient(id1);
        Patient p2 = new Patient(id2);
        Patient p3 = new Patient(id3);
        Patient p4 = new Patient(id4);
        list1.add(p1);
        list1.add(p3);
        list2.add(p2);
        list2.add(p4);
        PatientList merged = list1.merge(list1, list2);
        PatientList.Iterator iter = merged.new Iterator();
        assertSame(p1, iter.NextIndex());
        assertSame(p2, iter.NextIndex());
        assertSame(p4, iter.NextIndex());
        assertSame(p3, iter.NextIndex());
        assertNull(iter.NextIndex());
    }
    @Test
    void findEmptyList() {
        PatientList list = new PatientList();

        PatientID id = new PatientID(
                new Name("Bobert", "Jarmes"),
                new Date(1000));

        assertNull(list.find(id));
    }
    @Test
    void mergeTwoPeopleWithSameName() {
        PatientList list1 = new PatientList();
        PatientList list2 = new PatientList();
        Name n1 = new Name("Crazy", "Diamond");
        Name n2 = new Name("Psyduck", "Gengar");
        Name n3 = new Name("Psyduck", "Gengar");
        Name n4 = new Name("Michael", "Myers");
        PatientID id1 = new PatientID(n1, new Date(1345));
        PatientID id2 = new PatientID(n2, new Date(1918));
        PatientID id3 = new PatientID(n3, new Date(2834));
        PatientID id4 = new PatientID(n4, new Date(3251));
        Patient p1 = new Patient(id1);
        Patient p2 = new Patient(id2);
        Patient p3 = new Patient(id3);
        Patient p4 = new Patient(id4);
        list1.add(p1);
        list1.add(p3);
        list2.add(p2);
        list2.add(p4);
        PatientList merged = list1.merge(list1, list2);
        PatientList.Iterator iter = merged.new Iterator();
        assertSame(p1, iter.NextIndex());
        assertSame(p4, iter.NextIndex());
        assertSame(p2, iter.NextIndex());
        assertSame(p3, iter.NextIndex());
        assertNull(iter.NextIndex());
    }
    @Test
    void findSomeoneNotInList() {
        PatientList list = new PatientList();
        Name n1 = new Name("Crazy", "Diamond");
        Name n2 = new Name("Psyduck", "Gengar");
        Name n3 = new Name("jerome", "Williams");
        PatientID id1 = new PatientID(n1, new Date(1345));
        PatientID id2 = new PatientID(n2, new Date(1918));
        PatientID notInList = new PatientID(n3, new Date(523));
        Patient p1 = new Patient(id1);
        Patient p2 = new Patient(id2);

        list.add(p1);
        list.add(p2);

        assertNull(list.find(notInList));
    }
}