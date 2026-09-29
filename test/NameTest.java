import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void isNameSame() {
        Name nm1 = new Name("Abe","Lincoln");
        Name nm2 = new Name("Abe","Lincoln");
        assertTrue(nm1.match(nm2));

    }
    void isNameDiff() {
        Name nm1 = new Name("Abe","Lincoln");
        Name nm2 = new Name("Bob","Jones");
        assertTrue(nm1.match(nm2));
    }
    void isLastNameSame() {
        Name nm1 = new Name("Abe","Lincoln");
        Name nm2 = new Name("Joe","Lincoln");
        assertTrue(nm1.match(nm2));
    }

    @Test
    void isLessThanWithDiffLastNames() {

            Name nm1 = new Name("Abe","Lincoln");
            Name nm2 = new Name("Abe","Joe");
            assertFalse(nm1.isLessThan(nm2));

    }
    @Test
    void isLessThanWithDiffFirstNames() {

        Name nm1 = new Name("Abe","Lincoln");
        Name nm2 = new Name("Bob","Lincoln");
        assertTrue(nm1.isLessThan(nm2));

    }
    @Test
    void fullName() {
        Name nm = new Name("Cheddar", "Cheese");

        assertEquals("Cheese, Cheddar", nm.FullName("Cheddar", "Cheese"));
    }
}