
public class Patient {
    private PatientID identity = null;
    public Patient( PatientID id ) {
        identity=id;
    }
    public PatientID getIdentity() {
        return identity;
    }
    public String toString() {
        return "identity: " + identity.toString();
    }
}
