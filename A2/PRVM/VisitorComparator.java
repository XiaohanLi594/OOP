package PRVM;

import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        int lastNameComparison = v1.getLastName().compareTo(v2.getLastName());
        if (lastNameComparison == 0) {
            return v1.getFirstName().compareTo(v2.getFirstName());
        }
        return lastNameComparison;
    }
}