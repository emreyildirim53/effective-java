package Item11;

public class PhoneNumber {

    private int areaCode;
    private int prefix;
    private int lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode  = areaCode;
        this.prefix  = prefix;
        this.lineNumber = lineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;

        PhoneNumber pn = (PhoneNumber)o;
        return pn.lineNumber == lineNumber
                && pn.prefix  == prefix
                && pn.areaCode == areaCode;
    }
    
    // No hashCode() method!

    // The worst possible legal hashCode implementation - never use!  
    /*
    @Override 
    public int hashCode() { return 53; }
    */
    
    // Example of a successful hashcode
    //@Override
    public int hashCode() {
        int result = Integer.hashCode(areaCode);
        result = 31 * result + Integer.hashCode(prefix);
        result = 31 * result + Integer.hashCode(lineNumber);

        return result;
    }
}