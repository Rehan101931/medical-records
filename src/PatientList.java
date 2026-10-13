public class PatientList {


    private Patient[] PatientArray;
    private final int MAX_PATIENTS = 1000;
    private int nextAvailableIndex = 0;

    public PatientList() {
        PatientArray = new Patient[MAX_PATIENTS];
    }

    public boolean add( Patient pat ) {
        return add_ordered( pat );
    }
    public Patient find( PatientID id ) {
        return binary_search( id );
    }
    public PatientList merge(PatientList list1, PatientList list2) {
        PatientList.Iterator iter1 = list1.new Iterator();
        PatientList.Iterator iter2 = list2.new Iterator();
        PatientList merged = new PatientList();

        while (iter1.peek() != null && iter2.peek() != null) {
            if (iter1.peek().getIdentity().isLessThan(iter2.peek().getIdentity())) {
                merged.add(iter1.NextIndex());
            }
            else {
                merged.add(iter2.NextIndex());
            }
        }
        while (iter1.peek() != null) {
            merged.add(iter1.NextIndex());
        }
        while (iter2.peek() != null) {
            merged.add(iter2.NextIndex());
        }

        return merged;
    }
    private boolean add_ordered(Patient pat ) {
        if (nextAvailableIndex >= MAX_PATIENTS) {
            return false;
        }
        int current_index = nextAvailableIndex - 1;
        while (current_index >= 0 &&
                pat.getIdentity().isLessThan(PatientArray[current_index].getIdentity())) {
            PatientArray[current_index + 1] = PatientArray[current_index];
            current_index--;
        }
        PatientArray[current_index + 1] = pat;
        nextAvailableIndex++;
        return true;
    }
    private Patient binary_search( PatientID id ) {
        int lower_bound = 0;
        int upper_bound = nextAvailableIndex - 1;
        while (lower_bound <= upper_bound) {
            int mid = (lower_bound + upper_bound) / 2;
            PatientID middleID = PatientArray[mid].getIdentity();
            if (middleID.match(id)) {
                return PatientArray[mid];
            }
            if (middleID.isLessThan(id)) {
                lower_bound = mid + 1;
            }
            else {
                upper_bound = mid - 1;
            }
        }
        return null;
    }
    public class Iterator {
        private int IterationIndex;

        public Iterator() {
            IterationIndex=0;
        }
        public Patient NextIndex() {
            if(IterationIndex>=PatientArray.length || PatientArray[IterationIndex] == null){
                return null;
            } else {
                Patient pat = PatientArray[IterationIndex];
                IterationIndex++;
                return pat;
            }
        }
        public Patient peek() {
            if(IterationIndex<PatientArray.length){
                return PatientArray[IterationIndex];
            } else {
                return null;
            }
        }
    }
}
