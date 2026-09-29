import java.util.Date;

public class PatientID {
    private Name name = null;
    private Date dateOfBirth = null;
    public String toString() {
        return "name: " + name.toString() + " dob: " +
            dateOfBirth.toString();
    }

    Name getName() {
        return name;
    }

    Date getDateOfBirth() {
        return dateOfBirth;
    }

    public PatientID(Name nm, Date dob) {
        name = nm;
        dateOfBirth = dob;
    }

    public boolean match(PatientID other) {
        return name.match(other.getName()) &&
                dateOfBirth.equals(other.getDateOfBirth());
    }

    public boolean isLessThan(PatientID other) {
        if (name.isLessThan(other.getName())) {
            return true;
        } else {
            if (name.match(other.getName())) {
                if (dateOfBirth.before(other.getDateOfBirth())) {
                    return true;
                }
            }

        }
        return false;
    }
}