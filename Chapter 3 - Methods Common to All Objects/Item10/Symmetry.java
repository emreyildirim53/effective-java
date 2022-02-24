package Item10;

import java.util.Objects;

public final class Symmetry
{
    private final String s;
    
    public Symmetry(String s)
    {
        this.s = Objects.requireNonNull(s);
    }

    // Broken - violates symmetry!
    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Symmetry)
            return s.equalsIgnoreCase(((Symmetry) o).s);

        if (o instanceof String)  // One-way interoperability!
            return s.equalsIgnoreCase((String) o);
        
        return false;
    }
}