package Item10;

public class Equals
{
    // If you want it not to be used
    @Override public boolean equals(Object o) {
        throw new AssertionError(); // Method is never called
    }
    
    /// Roles ///
    
    Object x = new Object();
    Object y = new Object();
    Object z = new Object();
    
    //Reflexive
    public boolean equalsReflexivity() {
        return x.equals(x);                                    // must be true
    }

    //Symmetric
    public boolean equalsSymmetric() {
        return x.equals(y) && y.equals(z);                    // must be true
    }

    //Transitive
    public boolean equalsTransitive() {
        return x.equals(y) && y.equals(z) == x.equals(z);    // must be true
    }

    //Consistent
    public boolean equalsConsistent() {
        if (x.equals(y) == true) return true;                // must always be true
        if (x.equals(y) == false) return false;              // must always be false
        
        return false;
    }

    //Non-null
    public boolean equalsNonNull() {
        return x.equals(null);                              // must be false
    }
}
