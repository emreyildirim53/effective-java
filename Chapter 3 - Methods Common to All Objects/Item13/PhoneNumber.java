package Item13;

public class PhoneNumber
{

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
    
    @Override
    public int hashCode() {
        int result = Integer.hashCode(areaCode);
        result = 31 * result + Integer.hashCode(prefix);
        result = 31 * result + Integer.hashCode(lineNumber);

        return result;
    }
    
    // add tostring for a more meaningful code


    @Override
    public String toString()
    {
        return "PhoneNumber{" +
                "areaCode=" + areaCode +
                ", prefix=" + prefix +
                ", lineNumber=" + lineNumber +
                '}';
    }

    // Clone method for class with no references to mutable state
    @Override
    public PhoneNumber clone()
    {
        try
        {
            return (PhoneNumber) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError();  // Can't happen
        }
    }
}