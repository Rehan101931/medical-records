public class Name {
    public Name ( String first, String last ) {
        firstName=first.toLowerCase();
        lastName=last.toLowerCase();
    }
    public String toString() {
        return firstName + " " + lastName;
    }

    public String FullName (String firstName, String lastName ) {
        return lastName + ", " + firstName;
    }
    public boolean match( Name other ) {
        return firstName.equals(other.firstName) &&
                lastName.equals(other.lastName);

    }
    public boolean isLessThan(Name other ) {
        if (firstName.compareTo(other.firstName) < 0) {
            return true;
        } else if (firstName.equals(other.firstName)) {
            if (lastName.compareTo(other.lastName) < 0) {
                return true;
            }
        }

        return false;

    }
    private String firstName;
    private String lastName;
}
