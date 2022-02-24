package Item4;

import java.util.Arrays;

// Noninstantiable utility class
public class UtilityClass
{
    // Suppress default constructor for noninstantiability  
    private UtilityClass()
    {
        throw new AssertionError();
    }
}